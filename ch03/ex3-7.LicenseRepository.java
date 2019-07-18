// 코드 3-7 질의(Query) 메서드를 정의하는 LicenseRepository 인터페이스

package com.thoughtmechnix.licenses.repository;

import com.thoughtmechnix.licenses.model.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicenseRepository
    etends CrudRepository<License,String>
{
    public List<License> findByOrganizationId(String organizationId);
    public License findByOrganizationIdAndLicenseId
	(String organizationId, String licenseId);
}
