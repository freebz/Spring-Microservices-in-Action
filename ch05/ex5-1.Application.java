// 코드 5-1 서비스에서 히스트릭스를 활성화하는 @EnableCircuitBreaker 애너테이션

package org.thoughtmechanix.licenses;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
// 간결한 코드를 위해 import 삭제

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class Application {
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
	return new RestTemplate();
    }

    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
    }
}
