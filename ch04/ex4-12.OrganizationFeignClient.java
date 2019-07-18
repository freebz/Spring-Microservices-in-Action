// 코드 4-12 조직 서비스 호출을 위한 Feign 인터페이스 정의

/* 간결한 코드를 위해 나머지 삭제 */

@FeignClient("organizationservice")
public interface OrganizationFeignClient {
    @RequestMapping(
	method=RequestMethod.GET,
	value="/v1/organizations/{organizationId}",
	consumes="application/json")
    Organization getOrganization(
	@PathVariable("organizationId") String organizationId);
}
