// 코드 5-4 회로 차단기 호출에서 타임아웃 사용자 정의

@HsytrixCommand(
    commandProperties=
        {@HystrixProperty(
	    name="execution.isolation.thread.timeoutInMilliseconds",
	    value="12000")})
public List<License> getLicensesByOrg(String organizationId) {
    randomlyRunLong();

    return licenseRepository.findByOrganizationId(organizationId);
}
