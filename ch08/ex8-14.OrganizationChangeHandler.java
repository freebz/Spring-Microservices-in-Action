// 코드 8-14 OrganizationChangeHandler에서 새로운 사용자 정의 채널 사용

@EnableBinding(CustomChannels.class)
public class OrganizationChangeHandler {
    @StreamListener("inboundOrgChanges")
    public void loggerSink(OrganizationChangeModel orgChange) {
	... // 간결한 코드를 위해 삭제
    }
}
