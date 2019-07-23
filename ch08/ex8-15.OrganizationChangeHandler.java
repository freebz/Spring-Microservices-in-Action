// 코드 8-15 라이선싱 서비스에서 조직 변경 처리

@EnableBinding(CustomChannels.class)
public class OrganizationChangeHandler {
    @Autowired
    private OrganizationRepository organizationRedisRepository;

    private static final Logger logger =
	LoggerFactory.getLogger(OrganizationChangeHandler.class);

    @StreamListener("inboundOrgChanges")
    public void loggerSink(OrganizationChangeModel orgChange) {
	switch(orgChange.getAction()) {
	    // 간결한 코드를 위해 삭제
	case "UPDATE":
	    logger.debug("Received a UPDATE event from the organization service for organization id {}",
			 orgChange.getOrganizationId());
	    organizationRedisRepository
		.deleteOrganization(orgChange.getOrganizationId());
	    break;
	case "DELETE":
	    logger.debug("Received a DELETE event from the organization service for organization id {}",
			 orgChange.getOrganizationId());
	    organizationRedisRepository
		.deleteOrganization(orgChange.getOrganizationId());
	    break;
	default:
	    logger.error("Received an UNKNOWN event from the organization service o type {}",
			 orgChange.getType());
	    break;
	}
    }
}
