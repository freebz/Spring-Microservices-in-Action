// 코드 9-7 계측이 적용된 getOrg() 메서드

package com.thoughtmechanix.organization.services;

import com.thoughtmechanix.organization.events.source.SimpleSourceBean;

// 간결한 코드를 위해 import 삭제

@Service
public class OrganizationService {
    @Autowired
    private OrganizationREpository orgRepository;

    @Autowired
    private Tracer tracer;

    @Autowired
    SimpleSourceBean simpleSourceBean;

    private static final Logger logger =
	LoggerFactory.getLogger(OrganizationService.class);

    public Organization getOrg(String organizationId) {
	brave.Span newSpoan = tracer.nextSpan().name("getOrgDBCall");

	logger.debug("In the organizationService.getOrg() call");
	try (SpanInScope ws = tracer.withSpanInScope(newSpan.start())) {
	    return orgRepository.findById(organizationId);
	}
	finally {
	    newSpan.tag("peeer.service", "postgres");
	    newSpan.annotate("cr");
	    newSpan.finish();
	}
    }
    // 간결한 코드를 위해 이 클래스의 나머지 코드 삭제
}
