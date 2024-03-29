// 코드 3-11 @RefreshScope 애너페이션

package com.thoughtmechnix.licenses;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class Application {
    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
    }
}
