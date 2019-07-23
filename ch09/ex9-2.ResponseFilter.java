// 코드 9-2 주울 사후 필터로 스프링 클라우드 슬루스의 추적 ID 추가

package com.thoughtmechanix.zuulsvr.filters;

// 간결한 코드를 위해 다른 애너테이션 삭제

import brave.Tracer;

@Component
public class ResponseFilter extends ZuulFilter {
    private static final int     FILTER_ORDER = 1;
    private static final boolean SHOULD_FILTER = true;
    private static final Logger logger =
	LoggerFactory.getLogger(ResponseFilter.class);

    @Autowired
    Tracer tracer;

    @Override
    public String filterType() {return "post";}

    @Override
    public int filterOrder() {return FILTER_ORDER;}

    @Override
    public boolean shouldFilter() {return SHOULD_FILTER;}

    @Override
    public Object run() {
	RequestContext ctx = RequestContext.getCurrentContext();
	ctx.getResponse().addHeader("tmx-correlation-id",
				    tracer.currentSpan().context().traceIdString());
	return null;
    }
}
