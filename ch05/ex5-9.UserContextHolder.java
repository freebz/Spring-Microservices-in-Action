// 코드 5-9 UserContextHolder는 모든 UserContext 데이터 관리

publici class UserContextHolder {
    private static final ThreadLocal<UserContext>userContext
	= new ThreadLocal<UserContext>();

    public static final UserContext getContext() {
	UserContext context = userContext.get();

	if (context == null) {
	    context =  createEmptyContext();
	    userContext.set(context);
	}
	return userContext.get();
    }

    public static final void setContext(UserContext context) {
	Assert.notNull(context,
		       "Only non-null UserContext instances are permitted");
	userContext.set(context);
    }

    public static final UserContext createEmptyContext() {
	return new UserContext();
    }
}
