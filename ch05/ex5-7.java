// 코드 5-7 회로 차단기의 동작 구성

@HystrixCommand(
    fallbackMethod="buildFallbackLicenseList",
    threadPoolKey="licenseByOrgThreadPool",
    threadPoolProperties = {
	@HystrixProperty(name="coreSize", value="30"),
	@HystrixProperty(name="maxQueueSize", value="10")
    },
    commandProperties = {
	@HystrixProperty(name="circuitBreaker.requestVolumnThreshold", value="10"),
	@HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="75"),
	@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="7000"),
	@HystrixProperty(name="metrics.rollingStats.timeInMilliseconds", value="15000"),
	@HystrixProperty(name="metrics.rollingStats.numBuckets", value="5") }
)

public List<License> getLicenseByOrg(String organizationId) {
    logger.debug("LicenseService.getLicensesByOrg Correlation id: {}",
		 UserContextHolder.getContext().getCorrelationId());
    randomlyRunLong();

    return licenseRepository.findByOrganizationId(organizationId);
}
