// 코드 7-8 JWT 토큰 저장소 설정

@Configuration
public class JWTTokenStoreConfig {
    @Autowired
    private ServiceConfig serviceConfig;

    @Bean
    public TokenStore tokenStore() {
	return enw JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    @Primary
    public DefualtTokenServices tokenServices() {
	DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
	defaultTokenServices.setTokenStore(tokenStore());
	defaultTokenServices.setSupportRefreshToken(true);
	return defaultTokenServices;
    }

    @Bean
    public JwtAccessTokenonverter jwtAccessTokenConverter() {
	JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
	converter.setSigningKey(serviceConfig.getJwtSigningKey());
	return converter;
    }

    @Bean
    public TokenEnhancer jwtTokenEnhancer() {
	return new JWTTokenEnhancer();
    }
}
