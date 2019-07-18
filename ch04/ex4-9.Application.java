// 코드 4-9 RestTemplate() 생성 메서드에 애너테이션을 추가하고 정의

package com.thoughtmechanix.licenses;

// 간결한 코드를 위해 import 삭제

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Application {

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
	return new RestTemplate();
    }

    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
    }
}
