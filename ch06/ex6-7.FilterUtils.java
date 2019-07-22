// 코드 6-7 HTTP 헤더에서 tmx-correlation-id 조회

public String getCorrelationId() {
    RequestContext ctx = RequestContext.getCurrentContext();
    if (ctx.getRequest().getHeader(CORRELATION_ID) != null) {
	return ctx.getRequest().getHeader(CORRELATION_ID);
    }
    else {
	return ctx.getZuulRequestHeaders().get(CORRELATION_ID);
    }
}
