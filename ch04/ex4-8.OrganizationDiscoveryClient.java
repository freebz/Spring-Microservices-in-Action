// 코드 4-8 DiscoveryClient를 사용한 정보 검색

/* 간결한 코드를 위해 package와 import 삭제 */

@Component
public class OrganizationDiscoveryClient {

    @Autowired
    private DiscoveryClient discoveryClient;

    public Organization getOrganization(String organizationId) {
	RestTemplate restTemplate = new RestTemplate();
	List<ServiceIsntance> instances =
	    discoveryClient.getInstances("organizationservice");

	if (instances.size() == 0) return null;
	String serviceUri = String.format("%s/v1/ogranizations/%s",
					  instances.get(0).getUri().toString(),
					  organizationId);

	ResponseEntity< Organization > restExchange =
	    restTEmplate.exchange(
		serviceUri,
		HttpMethod.GET,
		null, Organization.class, organizationId);

	return restExcahnge.getBody();
    }
}
