// 코드 6-15 SpecialRoutesFilter의 run() 메서드는 작업이 시작되는 곳

public Object run() {
    RequestContext ctx = RequestContext.getCurrentContext();
    AbTestingRoute abTestRoute = getAbRoutingInfo(filterUtils.getServiceId());
    if (abTestRoute != null && useSpecialRoute(abTestRoute)) {
	String route = buildRouteString(ctx.getRequest().getRequestURI(),
					abTestRoute.getEndpoint(),
					ctx.get("serviceId").toString());
	forwardToSpecialRoute(route);
    }
    return null;
}
