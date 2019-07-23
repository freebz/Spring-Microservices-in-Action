// 코드 7-10 사용자 정의 RestTemplate 클래스를 생성해 JWT 토큰 삽입

public class Application {

    // 간결한 코드를 위해 삭제

    @Primary
    @Bean
    public RestTemplate getCustomRestTemplate() {
	RestTemplate template = new RestTemplate();
	List interceptors = template.getInterceptors();
	if (interceptors == null) {
	    template.setInterceptors(Collections.singletonList(
					 new UserContextInterceptor()));
	} else {
	    interceptors.add(new UserContextInterceptor());
	    template.setInterceptor(interceptors);
	}
	return template;
    }
}
