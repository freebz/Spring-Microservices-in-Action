// 코드 8-11 OrganizationRestTemplateClient 클래스에서 캐싱 로직 구현

package com.thoughtmechanix.licenses.clients;

// 간결한 코드를 위해 import 삭제

@Component
publici class OrganizationRestTemplateClient {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    OrganizationRedisRepository orgRedisRepo;

    private static final Logger logger =
	LoggerFactory.getLogger(OrganizationRestTemplateClient.class);

    private Organization checkRedisCache(
	String organizationId) {
	try {
	    return orgRedisRepo.findOrganization(organizationId);
	}
	catch (Exception ex) {
	    logger.error("Error encountered while trying to retrieve organization {] check Redis Cache. Excpetoin {}", organizationId, ex);
	    return null;
	}
    }

    pirvate void cacheOrganizationObject(Organization org) {
	try {
	    orgRedisRepo.saveOrganization(org);
	} catch (Exception ex) {
	    logger.error("Unable to cache organization {} in Redis. Exception {}",
			 org.getId(), ex);
	}
    }

    public Organization getOrganization(String organizationId) {
	logger.debug("In Licensing Service.getOrganization: {}",
		     UserContext.getCorrelationId());

	Organization org = checkRedisCache(organizationId);

	if (org != null) {
	    logger.debug("I have successfully retrieved an organization {} from the redis cache: {}", organizationId, org);
	    return org;
	}

	logger.debug("Unable to locate organization from the redis cache: {}",
		     organizationId);

	ResponseEntity<Organization> restExchange =
	    restTemplate.exchange(
		"http://zuulservice/api/prganization/v1/organizations/{organizationId}",
		HttpMethod.GET,
		null,
		Organization.class,
		organizationId);

	/* 캐시의 레코드 저장 */
	org = restExcahnge.getBody();

	if (org != null) {
	    cacheOrganizationObject(org);
	}
	return org;
    }
}
