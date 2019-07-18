// 코드 5-12 스프링 클라우드로 사용자 정의 HystrixConcurrencyStrategy 클래스 후킹

package com.thoughtmechanix.licenses.hystrix;

// 간결한 코드를 위해 import 삭제

@Configuration
public class ThreadLocalConfiguration {
    @Autowired(required=false)
    private HystrixConcurrencyStrategy existingConcurrencySterategy;

    @PostConstruct
    public void init() {
	// 기존 히스트릭스 플러그인의 레퍼런스 유지
	HystrixEventNotifier eventNotifier =
	    HystrixPlugins.getInstance().getEventNotifier();
	HystrixMetricsPublisher metricsPublisher =
	    HystrixPlugins.getInstance().getMetricsPublisher();
	HystrixPropertiesStrategy propertiesStrategy =
	    HystrixPlugins.getInstance().getPropertiesStrategy();
	HystrixCommandExecutionHook commandExecutionHook =
	    HystrixPlugins.getInstance().getCommandExecutionHook();

	HystrixPlugins.reset();

	HystrixPlugins.getInstance().registerConcurrencyStrategy(
	    new ThreadLocalAwareStrategy(existingConcurrencySterategy));
	HystrixPlugins.getInstance().registerEventNotifier(eventNotifier);
	HystrixPlugins.getInstance().registerMetricsPublisher(metricsPublisher);
	HystrixPlugins.getInstance().registerPropertiesStrategy(propertiesStrategy);
	HystrixPlugins.getInstance().registerCommandExecutionHook(commandExecutionHook);
    }
}
