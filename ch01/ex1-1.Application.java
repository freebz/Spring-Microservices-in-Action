// 코드 1-1 스프링 부트로 만든 Hello World 마이크로서비스

package com.thoughtmechanix.simpleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootApplication
@RestController
@RequestMapping(value="hello")
public class Application {
    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
    }

    @RequestMapping(value="/{firstName}/{lastName}",
		    method=RequestMethod.GET)
    public String hello(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {

	return String.format("{\"message\":\"Hello %s %s\"}",
			     firstName, lastName);
    }
}
