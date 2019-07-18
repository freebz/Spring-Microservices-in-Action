// 코드 4-3 유레카 서버를 활성화하는 부트스트랩 클래스에 애너테이션 추가

package com.thoughtmechanix.eurekasvr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
	SpringApplication.run(EurekaServerApplication.class, args);
    }
}
