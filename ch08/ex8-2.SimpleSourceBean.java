// 코드 8-2 메시지 브로커에 메시지 발행

package com.thoughtmechanix.organization.events.source;

// 간결한 코드를 위해 import 삭제

@Component
public class SimpleSourceBean {
    private Source source;

    private static final Logger logger =
	LoggerFactory.getLogger(SimpleSourceBean.class);

    @Autowired
    public SimpleSourceBean(Source source) {
	this.source = source;
    }

    public void publishOrgChange(String action, String orgId) {
	logger.debug("Sending Kafka message {} for Organization Id: {}",
		     action, orgId);
	OrganizationChangeModel change = new OrganizationChangeModel(
	    OrganizationChangeModel.class.getTypeName(),
	    action,
	    orgId,
	    UserContext.getCorrelationId());

	source
	    .output()
	    .send(
		MessageBuilder
		.withPayload(change)
		.build());
    }
}
