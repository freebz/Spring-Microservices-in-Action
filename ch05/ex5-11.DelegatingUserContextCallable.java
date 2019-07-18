// 코드 5-11 DelegatingUserContextCallable.java로 UserContext 전파

package com.thoughtmechanix.licenses.hystrix;

// 간결한 코드를 위해 import 삭제

public final class DelegatingUserContextCallable<V>
  implements Callable<V> {
    private final Callable<V> delegate;
    private UserContext originalUserContext;

    public DelegatingUserContextCallable(Callable<V> delegate,
					 UserContext userContext) {
	this.delegate = delegate;
	this.originalUserContext = userContext;
    }

    public V call() throws Exception {
	UserContextHolder.setContext(originalUserContext);
	try {
	    return delegate.call();
	}
	finally {
	    this.originalUserContext = null;
	}
    }

    public static <V> Callable<V> create(Callable<V> delegate,
					 UserContext userContext) {
	return new DelegatingUserContextCallable<V>(delegate, userContext);
    }
}
