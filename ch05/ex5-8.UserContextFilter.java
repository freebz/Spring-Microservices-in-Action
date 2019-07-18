// 코드 5-8 HTTP 헤더를 파싱하고 데이터를 검색하는 UserContextFilter

package com.thoughtmechanix.licenses.utils;

// 간결한 코드를 위해 일부 코드 삭제

@Component
public class UserContextFilter implements Filter {
    private static final Logger logger =
	LoggerFactory.getLogger(UserContextFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest,
			 ServletResponse servletResponse, FilterChain filterChain)
	    throws IOException, ServletException {
	HttpServletRequest httpServletRequest =
	    (HttpServletRequest) servletRequest;

	UserContextHolder.getContext().setCorrelationId(
	    httpServletRequest.getHeader(UserContext.CORRELATION_ID));
	UserContextHolder.getContext().setUserId(
	    httpServletRequest.getHeader(UserContext.USER_ID));
	UserContextHolder.getContext().setAuthToken(
	    httpServletRequest.getHeader(UserContext.AUTH_TOKEN));
	UserContextHolder.getContext().setORgId(
	    httpServletRequest.getHeader(UserContext.ORG_ID));

	logger.debug("UserContextFilter Correlation id: {}",
		     UserContextHolder.getContext().getCorrelationId());

	filterChain.doFilter(httpServletRequest, servletResponse);
    }
}
