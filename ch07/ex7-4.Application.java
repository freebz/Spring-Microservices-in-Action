// 코드 7-4 보호 자원으로 만들기 위해 부트스트랩 클래스 구성

package com.thoughtmechanix.organization;

// 간결한 코드를 위해 import 삭제

import org.springframework.security.oauth2.
    config.annotation.web.configuration.EnableResourceServer;
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableResourceServer
public class Application {
    @Bean
    public Filter userContextFilter() {
	UserContextFilter userContextFilter = new UserContextFilter();
	return userContextFilter;
    }
    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
    }
}
