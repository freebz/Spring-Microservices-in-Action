// 코드 3-8 데이터베이스 명령을 실행하는 LicenseService 클래스

package com.thoughtmechnix.licenses.services;

import com.thoughtmechnix.licenses.config.ServiceConfig;
import com.thoughtmechnix.licenses.model.License;
import com.thoughtmechnix.licenses.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LicenseService {

    @Autowired
    private LicenseRepository licenseRepository;

    @Autowired
    ServiceConfig config;

    public License getLicense(String organizationId, String licenseId) {
	License license =
	    licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
	return license.withComment(config.getExampleProperty());
    }

    public List<License> getLicensesByOrg(String organizationId) {
	return licenseRepository.findByOrganizationId(organizationId);
    }

    public void saveLicense(License license) {
	license.withId(UUID.randomUUID().toString());

	licenseRepository.save(license);

    }
    /* 간결한 코드를 위해 나머지 삭제 */
}
