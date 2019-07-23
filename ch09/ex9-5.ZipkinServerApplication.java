// 코드 9-5 집킨 서버의 부트스트랩 클래스 작성

package com.thoughtmechanix.zipkinsvr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ZipkinServerApplication {
    public static void main(String[] args) {
	SpringApplication.run(ZipkinServerApplication.class, args);
    }
}
