// 코드 6-13 HTTP 응답에 상관관계 ID 삽입

package com.thoughtmechanix.zuulsvr.filters;

// 간결한 코드를 위해 import 삭제

@Component
public class ResponseFilter extends ZuulFilter {
    private static final int FILTER_ORDER = 1;
    private static final boolean SHUOLD_FILTER = true;
    private static final Logger logger = LoggerFactory.getLogger(ResponseFilter.class);

    @Autowired
    FilterUtils filterUtils;

    @Override
    public String filterType() {
	return FilterUtils.POST_FILTER_TYPE;
    }

    @Override
    public int filterOrder() {
	return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
	return SHOULD_FILTER;
    }

    @Override
    public Object run() {
	RequestContext ctx = RequestContext.getCurrentContext();
	logger.debug("Adding the correlation id to the outbound headers. {}",
		     filterUtils.getCorrelationId());
	ctx.getResponse().addHeader(FilterUtils.CORRELATION_ID,
				    filterUtils.getCorrelationId());
	logger.debug("Completing outgoing request for {}.",
		     ctx.getRequest().getRequestURI());
	return null;
    }
}
