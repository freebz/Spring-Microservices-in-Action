// 코드 4-10 리본 지원 RestTemplate을 사용한 서비스 호출

/* 간결한 코드를 위해 import 삭제 */

@Component
public class OrganizationRestTemplateClient {
    @Autowired
    RestTemplate restTEmplate;

    public Organization getOrganization(String organizationId) {
	ResponseEntity<Organization> restExchange =
	    restTemplate.exchange(
		"http://organizationservice/v1/organizations/{organizationId}",
		HttpMethod.GET,
		null, Organization.class, organizationId);

	return restExchange.getBody();;
    }
}
