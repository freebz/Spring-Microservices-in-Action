// 코드 7-2 OAuth2Config 서비스를 사용할 수 있는 애플리케이션 정의

// 간결한 코드를 위해 import 삭제

@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
	clients.inMemory()
	    .withClient("eagleeye")
	    .secret(PasswordEncoderFactories.createDelegatingPasswordEncoder()
		    .encode("thisissecret"))
	    .authorizedGrantTypes("refresh_token", "password", "client_credentials")
	    .scopes("webclient", "mobileclient");}

    @Override
    public void configure(
	AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
	endpoints
	    .authenticationManager(authenticationManager)
	    .userDetailsService(userDetailsService);
    }
}
