// 코드 4-6 getLicense() 메서드는 다양한 방법으로 REST 호출 수행

public License getLicense(String organizationId,
			  String licenseId, String clientType) {
    License license = licenseRepository.findByOrganizationIdAndLicenseId(
	organizationId, licenseId);
    Organization org = retrieveOrgInfo(organizationId, clientType);

    return license
	.withOrganizationName(org.getName())
	.withContactName(org.getContactName())
	.withContactEamil(org.getContactEmail())
	.withContactPhone(org.getContactPhone())
	.withComment(config.getExampleProperty());
}
