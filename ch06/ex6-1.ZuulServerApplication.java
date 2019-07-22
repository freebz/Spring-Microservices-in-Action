// 코드 6-1 주울 서버의 부트스트랩 클래스 설정

package com.thoughtmechanix.zuulsvr;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnalbeZuulProxy
public class ZuulServerApplication {
    public static void main(String[] args) {
	SpringApplication.run(ZuulServerApplication.class, args);
    }
}
