// 코드 6-18 대체 서비스를 호출하는 forwardToSpecialRoute

private ProxyRequestHelper helper = new ProxyRequestHelper();
private void forwardSpecialRoute(String route) {
    RequestContext context = RequestContext.getCurrentContext();
    HttpServletRequest request = context.getRequest();

    MultiValueMap<String, String> params = helper.buildZuulRequestHeaders(request);

    MultiValueMap<String, String> params = helper.buildZuulRequestQueryParams(request);

    String verb = getVerb(request);
    InputStream requestEntity = getRequestBody(request);
    if (request.getContentLength() < 0)
	context.setChunkedRequestBody();

    this.helper.addIgnoreHeaders();
    CloseableHttpClient httpClient = null;
    HttpResponse response = null;

    try {
	httpClient = HttpClients.createDefault();
	response = forward(
			   httpClient,
			   verb,
			   route,
			   request,
			   headers,
			   params,
			   requestEntity);
	setResponse(response);
    }
    catch (Exception ex) { /* 간결한 코드를 위해 삭제 */ }
}
