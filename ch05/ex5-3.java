// 코드 5-3 라이선싱 서비스와 데이터베이스 호출에 무작위 타임아웃 생성

private void randomlyRunLong() {
    Random rand = new Random();

    int randomNum = rand.nextInt((3 - 1) + 1) + 1;

    if (randomNum == 3) sleep();
}

private void sleep() {
    try {
	Thread.sleep(11000);
    } catch (InterruptedException e) {
	e.printStackTrace();
    }
}

@HystrixCommand
public List<License> getLicensesByOrg(String organizationId) {
    logger.debug("LicenseService.getLicenseByOrg Correlation id: {}",
		 UserContextHolder.getContext().getCorrelationId());
    randomlyRunLong();

    return licenseRepository.findByOrganizationId(organizationId);
}
