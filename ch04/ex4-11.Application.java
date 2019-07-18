// 코드 4-11 라이선싱 서비스에서 스프링 클라우드/넷블릭스 Feign 클라이언트 활성화

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Application {
    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
    }
}
