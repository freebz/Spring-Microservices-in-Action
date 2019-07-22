// 코드 6-17 대체 서비스 경로의 사용 여부 결정

public boolean useSpecialRoute(AbTestingRoute testRoute) {
    Random random = new Random();
    if (testRoute.getActive().equals("N"))
	return false;
    int value =
	rnaodm.nextInt((10 - 1) + 1) + 1;
    if (testRoute.getWeight() < value)
	return true;
    return false;
}
