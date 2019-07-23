// 코드 7-7 OAuth2RestTemplate으로 OAuth2 액세스 토큰 전파

package com.thoughtmechanix.licenses.clients;
// 간결한 코드를 위해 import 삭제

@Component
public class OrganizationRestTemplateClient {
    @Autowired
    OAuth2RestTemplate restTemplate;
    private static final Logger logger =
	LoggerFactory.getLogger(OrganizationRestTemplateClient.class);
    public Organization getOrganization(String organizationId) {
	logger.debug("In Licensing Service.getOrganization: {}",
		     UserContext.getCorrelationId());
	ResponseEntity<Organization> restExchange =
	    restTemplate.exchange(
		"http://zuulserver:5555/api/organization/v1/organizations/{organizationId}", HttpMethod.GET,
		null, Organization.class, organizationId);
	/* 개시의 데이터 저장 */
	return restExchange.getBody();
    }
}
