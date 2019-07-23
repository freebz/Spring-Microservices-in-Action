// 코드 7-14 JWT 토큰에서 organizationId 파싱

private String getOrganizationId() {
    String result = "";
    if (filterUtils.getAuthToken() != null) {
	String authToken =
	    filterUtils.getAuthToken().replace("Bearer ", "");
	try {
	    Claims claims = Jwts.parser()
		.setSigningKey(serviceConfig.getJwtSigningKey()
			       .getBytes("UTF-8"))
		.parseClaimsJws(authToken).getBody();
	    result = (String) claims.get("organizationId");
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
    }
    return result;
}
