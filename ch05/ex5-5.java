// 코드 5-5 히스트릭스에서 폴백 구현

@HystrixCommand(fallbackMethod="buildFallbackLicenseList")
public List<License> getLicensesByOrg(String organizationId) {
    logger.debug("LicenseService.getLicensesByOrg Correlation id: {}",
		 UserContextHolder.getContext().getCorrelationId());
    randomlyRunLong();

    return licenseRepository.findByOrganizationId(organizationId);
}

private List<License> buildFallbackLicenseList(String organizationId) {
    List<License> fallbackList = new ArrayList<>();
    License license = new License()
	.withId("0000000-00-00000")
	.withOrganizationId(organizationId)
	.withProductName(
	    "Sorry no licensing information currently available");
    fallbackList.add(license);
    return fallbackList;
}
