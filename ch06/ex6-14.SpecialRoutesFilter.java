// 코드 6-14 기본적인 경로 필터

package com.thoughtmechanix.zuulsvr.filters;
@Component
public class SpecialRoutesFilter extends ZuulFilter {
    @Override
    public String filterType() {
	return filterUtils.ROUTE_FILTER_TYPE;
    }

    @Override
    public int filterOrder() {}

    @Override
    public boolean shouldFilter() {}

    @Override
    public Object run() {}
}
