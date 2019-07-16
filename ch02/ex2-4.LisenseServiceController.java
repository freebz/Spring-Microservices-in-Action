// 코드 2-4 개별 GET HTTP 엔드포인트 노출(LicenseServiceController.java)

@RequestMapping(value="/{licenseId}", method=RequestMethod.GET)
public License getLicenses(
    @PathVariable("organizationId") String organizationId,
    @PathVariable("licenseId") String licenseId) {
    return new License()
	.withId(licenseId)
	.withOrganizationId(organizationId)
	.withProductName("Teleco")
	.withLicenseType("Seat");
}
