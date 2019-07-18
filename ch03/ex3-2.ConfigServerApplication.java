// 코드 3-2 스프링 클라우드 컨피그 서버의 부트스트랩 클래스

package com.thoughtmechnix.confsvr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
    public static void main(String[] args) {
	SpringApplication.run(ConfigServerApplication.class, args);
    }
}
