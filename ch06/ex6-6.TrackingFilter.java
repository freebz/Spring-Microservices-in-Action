// 코드 6-6 상관관계 ID를 생성하는 주울의 사전 필터

package com.thoughtmechanix.zuulsvr.filter;

import com.netflix.zuul.ZuulFilter;
import org.springframework.beans.factory.annotation.Autowired;

// 간결한 코드를 위해 import 삭제

@Component
public class TrackingFilter extends ZuulFilter {
    private static final int     FILTER_ORDER = 1;
    private static final boolean SHUOLD_FILTER = true;
    private static final Logger logger = LoggerFactory.getLogger(TrackingFilter.class);

    @Autowired
    FilterUtils filterUtils;

    @Override
    public String filterType() {
	return FilterUtils.PRE_FILTER_TYPE;
    }

    @Override
    public int filterOrder() {
	return FILTER_ORDER;
    }

    public boolean shouldFilter() {
	return SHOULD_FILTER;
    }

    private boolean isCorrelationIdPresent() {
	if (filterUtils.getCorrelationId() != null) {
	    return true;
	}

	return false;
    }

    private String generateCorrelationId() {
	return java.util.UUID.randomUUID().toString();
    }

    public Object run() {
	if (isCorrelationIdPresent()) {
	    logger.debug("tmx-correlation-id found in tracking filter: {}.",
			 filterUtils.getCorrelationId());
	}
	else {
	    filterUtils.setCorrelationId(generateCorrelationId());
	    logger.debug("tmx-correlation-id generated in tracking filter: {}.",
			 filterUtils.getCorrelationId());
	}

	RequestContext ctx = RequestContext.getCurrentContext();
	logger.debug("Processing incoming request for {}.",
		     ctx.getRequest().getRequestURI());
	return null;
    }
}
