// 코드 8-4 조직 서비스에서 메시지 발행

package com.thoughtmechanix.organization.services;

// 간결한 코드를 위해 import 삭제

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository orgRepository;

    @Autowired
    SimpleSourceBean simpleSourceBean;

    // 간결한 코드를 위해 나머지 삭제

    public void saveOrg(Organization org) {
	org.setId(UUID.randomUUID().toString());

	orgRepository.save(org);
	simpleSourceBean.publishOrgChange("SAVE", org.getId());
    }
}
