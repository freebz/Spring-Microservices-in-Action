// 코드 7-5 인증된 사용자만 접근할 수 있도록 제한

package com.thoughtmechanix.organization.security;

// 간결한 코드를 위해 import 삭제

@Configuration
public class ResourceServerConfiguration extends
					     ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests().anyRequest().authnticated();
    }
}
