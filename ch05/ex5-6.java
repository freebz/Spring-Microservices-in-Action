// 코드 5-6 getLicensesByOrg() 메서드를 감싸는 벌크헤드 생성

@HystrixCommand(fallbackMethod="buildFallbackLicenseList",
  threadPoolKey="licenseByOrgThreadPool",
  threadPoolProperties =
    {@HystrixProperty(name="coreSize", value="30"),
     @HystrixProperty(name="maxQueueSize", value="10")},
)
public List<License> getLicensesByOrg(String organizationId) {
    return licenseRepository.findByOrganizationId(organizationId);
}
