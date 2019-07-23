// 코드 8-5 스프링 클라우드 스트림을 사용해 메시지 소비

package com.thoughtmechanix.licenses;

// 간결한 코드를 위해 import 삭제

@EnableBinding(Sink.class)
public class Application {
    // 간결한 코드를 위해 삭제
    @StreamListener(Sink.INPUT)
    public void loggerSink(
	OrganizationChangeModel orgChange) {
	logger.debug("Received an event for organization id {}",
		     orgChange.getOrganizationId());
    }
}
