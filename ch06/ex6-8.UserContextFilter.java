// 코드 6-8 상관관계 ID를 UserContext 클래스에 매핑

package com.thoughtmechanix.licenses.utils;

// 간결한 코드를 위해 import 삭제
@Component
public class UserContextFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(UserContextFilter.class);
    @Override
    public void doFilter(ServletRequest servletRequest,
			 ServletResponse servletResponse,
			 FilterChain filterChain) throws IOException, ServletException {
	HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
	UserContextHolder.getContext().setCorrelationId(
	    httpServletRequest.getHeader(UserContext.CORRELATION_ID));
	UserContextHolder.getContext().setUserId(
	    httpServletRequest.getHeader(UserContext.USER_ID));
	UserContextHolder.getContext().setAuthToken(
	    httpServletRequest.getHeader(UserContext.AUTH_TOKEN));
	UserContextHolder.getContext().setOrgId(
	    httpServletRequest.getHeader(UserContext.ORG_ID));
	filterChain.doFilter(httpServletRequest, servletResponse);
    }
    // 선언만 있는 init()와 destroy() 메서드는 표시하지 않음
}
