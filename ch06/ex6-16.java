// 코드 6-16 라우팅 레코드 유무 확인을 이ㅜ해 SpecialRoutesFilter 호출

private AbTestingRoute getAbRoutingInfo(String serviceName) {
    ResponseEntity<AbTestingRoute> restExchange = null;
    try {
	restExchange = restTemplate.exchange(
	    "http://specialroutesservice/v1/route/abtesting/{serviceName}",
	    HttpMethod.GET, null, AbTestingRoute.class, serviceName);
    }
    catch(HttpClientErrorException ex) {
	if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
	    return null;
	}
	throw ex;
    }
    return restExchange.getBody();
}
