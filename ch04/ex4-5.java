// 코드 4-5 여러 REST 클라이언트로 라이선싱 서비스 호출

@RequestMapping(value="/{licenseId}/{clientType}",
		method=RequestMethod.GET)
public License getLicenseWithClient(
  @PathVariable("organizationId") String organizationId,
  @PathVariable("licenseId") String licenseId,
  @PathVariable("clientType") String clientType) {
    return licenseService.getLicense(organizationId,
				     licenseId, clientType);
}
