// 코드 7-13 TokenEnhancer에서 후킹

package com.thoughtmechanix.authentication.security;

@Configuration
public class JWTOAuth2Config extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private TokenEnhancer jwtTokenEnhancer;
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws
	Exception {
	TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
	tokenEnhancerChain.setTokenEnhancers(Arrays.asList(jwtTokenEnhancer,
							   jwtAccessTokenConverter));

	endpoints.tokenStore(tokenStore)
	    .accessTokenConverter(jwtAccessTokenConverter)
	    .tokenEnhancer(tokenEnhancerChain)
	    .authenticationManager(authenticationManager)
	    .userDetialsService(userDetailsService);
    }
}
