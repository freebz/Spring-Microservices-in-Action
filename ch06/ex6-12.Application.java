// 코드 6-12 RestTemplate 클래스에 UserContextInterceptor 추가

@LoadBalanced
@Bean
public RestTemplate getRestTemplate() {
    RestTemplate template = new RestTemplate();
    List interceptors = template.getInterceptors();
    if (interceptors == null) {
	template.setInterceptors(Collections.singletonList(new UserContextInterceptor()));
    }
    else {
	interceptors.add(new UserContextInterceptor());
	template.setInterceptors(interceptors);
    }
    return template;
}
