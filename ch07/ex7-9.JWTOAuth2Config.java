// 코드 7-9 WJTOAuth2Config 클래스로 JWT를 인증 서비스에 연결

package com.thoughtmechanix.authentication.security;

// 간결한 코드를 위해 import 삭제

@Configuration
public class JWTOAuth2Config extends
				 AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private TokenStore tokenStore;
    @Autowired
    private DefaultTokenServices tokenServices;
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Override
    public void configure(
	AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
	TokenEnhancerChain tokenEnhancerChain =
	    new TokenEnhancerChain();
	tokenEnhancerChain.setTokenEnhancers(
	    Arrays.asList(
		jwtTokenEnhancer,
		jwtAccessTokenConverter));
	endpoints
	    .tokenStore(tokenStore)
	    .accessTokenConverter(jwtAccessTokenConverter)
	    .authenticationManager(authnticationManager)
	    .userDetailsService(userDetailsService);
    }
    // 간결한 코드를 위해 나머지 삭제
}
