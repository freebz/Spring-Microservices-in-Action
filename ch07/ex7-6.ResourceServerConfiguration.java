// 코드 7-6 ADMIN 역할만 삭제하도록 제한

package com.thoughtmechanix.organization.security;

// 간결한 코드를 위해 import 삭제

@Configuration
public class ResourceServerConfiguration extends
					     ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
	http
	    .authorizeRequests()
	    .antMatchers(HttpMethod.DELETE, "/v1/organizations/**")
	    .hasRole("ADMIN")
	    .anyRequest()
	    .authenticated();
    }
}
