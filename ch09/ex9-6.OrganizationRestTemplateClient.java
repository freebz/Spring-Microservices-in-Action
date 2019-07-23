// 코드 9-6 레디스에서 라이선싱 데이터를 읽어 오는 호출 측정

import brave.Tracer;
import brave.Tracer.SpanInScope;

// 간결한 코드를 위해 import 삭제

@Component
public class OrganizationRestTemplateClient {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Tracer tracer;

    @Autowired
    OrganizationRedisRepository orgRedisRepo;

    private static final Logger logger =
	LoggerFactory.getLogger(OrganizationRedisRepository.class);

    private Organization checkRedisCache(String organizationId) {
	brave.Span newSpan = tracer.nextSpan().name("readLicensingDataFromRedis");
	try (SpanInScope ws = tracer.withSpanInScope(newSpan.start())) {
	    return orgRedisRepo.findOrganization(organizationId);
	}
	catch (Exception ex) {
	    logger.error("Error encountered while trying to retrieve organization {} check Redis Cache. Exception {}", organizationId, ex);
	    return null;
	}
	finally {
	    newSpan.tag("peer.service", "redis");
	    newSpan.annotate("cr");
	    newSpan.finish();
	}
    }
        // 간결한 코드를 위해 클래스의 나머지 코드 삭제
}
