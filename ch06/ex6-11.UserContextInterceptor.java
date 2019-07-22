// 코드 6-11 마이크로서비스의 모든 발신 호출에 상관관계 ID 삽입

package com.thoughtmechanix.licenses.utils;

// 간결한 코드를 위해 import 삭제

public class UserContextInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(
	HttpRequest request, byte[] body,
	ClientHttpRequestExecution execution) throws IOException {
	HttpHeaders headers = request..getHeaders();
	headers.add(
	    UserContext.CORRELATION_ID,
	    UserContextHolder.getContext().getCorrelationId());
	headers.add(UserContext.AUTH_TOKEN,
		    UserContextHolder.getContext().getAuthToken());
	return execution.execute(request, body);
    }
}
