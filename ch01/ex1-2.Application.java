// 코드 1-2 스프링 클라우드를 사용하는 Hello World 서비스

package com.thoughtmechanix.simpleservice;

// 간결한 코드를 위해 삭제
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springframework.cloud.netflix.eureka.EnableEurekaClient;
import com.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@RestController
@RequestMapping(value="hello")
@EnableCircuitBreaker
@EnableEurekaClient
public class Application {
    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
    }

    @HystrixCommand(threadPoolKey="helloThreadPool")
    public String helloRemoteServiceCall(String firstName, String lastName) {
	ResponseEntity<String> restExchange =
	    restTemplate.exchange(
		"http://logical-service-id/name/[ca]{firstName}/{lastName}",
		HttpMethod.GET,
		null, String.class, firstName, lastName);
	return restExchange.getBody();
    }
    
    @RequestMapping(value="/{firstName}/{lastName}",
		    method=RequestMethod.GET)
    public String hello(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {

	return helloRemoteServiceCall(firstName, lastName);
    }
}
