// 코드 4-7 유레카 Discovery Client를 사용하기 위해 부트스트랩 클래스 설정

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Application {
    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
    }
}
