// 코드 5-2 회로 차단기로 원격 자원 호출 감싸기

// 간결한 코드를 위해 import 삭제

@HystrixCommand
private Origanization getOrganization(String organizationId) {
    return organizationRestClient.getOrganization(organizationId);
}
