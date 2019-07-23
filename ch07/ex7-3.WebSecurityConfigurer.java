// 코드 7-3 애플리케이션에 대한 사용자 ID와 패스워드, 역할 정의

package com.thoughtmechanix.authentication.security;

// 간결한 코드를 위해 import 삭제

@Configuration
public class WebSecirutyConfigurer extends
				       WebSecurityConfigurerAdapter {
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
	return super.authenticationManagerBean();
    }
    @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
	return super.userDetailsServiceBean();
    }
    @Override
    protected void configure(AuthnticationManagerBuilder auth) throws Exception {
	PasswordEncoder encoder =
	    PasswordEncoderFactories.createDelegatingPasswordEncoder();
	auth
	    .inMemoryAuthntication()
	    .passwordEncoder(encoder)
	    .withUser("john.carnell").password(encoder.encode("password")).roles("USER")
	    .and()
	    .withUser("william.woodward").password(encoder.encode("password2")).
	        roles("USER", "ADMIN");
    }
}
