// 코드 5-10 히스트릭스의 병행성 전략 정의

package com.thoughtmechanix.licenses.hystrix;

// 간결한 코드를 위해 import 삭제

public class ThreadLocalAwareStrategy extends HystrixConcurrencyStrategy {
    private HystrixConcurrencyStrategy existingConcurrencySterategy;

    public ThreadLocalAwareStrategy(
	HystrixConcurrencystrategy existingConcurrencySterategy) {
	this.existingConcurrencySterategy = existingConcurrencySterategy;
    }

    @Override
    public BlockingQueue<Runnable> getBlockingQueue(int maxQueueSize) {
	return existingConcurrencySterategy != null
	    ? existingConcurrencySterategy.getBlockingQueue(maxQueueSize)
	    : super.getBlockingQueue(maxQueueSize)
	    }

    @Override
    public <T> HystrixRequestVariable<T> getRequestVariable(
	HystrixRequestVariableLifecycle<T> rv)
    {
	// 간결한 코드를 위해 삭제
    }

    // 간결한 코드를 위해 삭제

    @Override
    public ThreadPoolExecutor getThreadPool(
	HystrixThreadPoolKey threadPoolKey,
	HystrixProperty<Integer> corePoolSize,
	HystrixProperty<Integer> maximumPoolSize,
	HystrixProperty<Integer> keepAliveTime,
	TimeUnit unit,
	BlockingQueue<Runnable> workQueue)
    {
	// 간결한 코드를 위해 삭제
    }

    @Override
    public <T> Callable<T> wrapCallable(Callable<T> callable) {
	return existingConcurrencySterategy != null
	    ? existingConcurrencySterategy.wrapCallable(
		new DelegatingUserContextCallable<T>(
		    callable, UserContextHolder.getContext()))
	    : super.wrapCallable(
		new DelegatingUserContextCallable<T>(
		    callable, UserContextHolder.getContext()));
    }
}
