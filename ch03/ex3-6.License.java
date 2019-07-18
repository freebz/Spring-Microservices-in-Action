// 코드 3-6 License 레코드의 JPA 모델 코드

package com.thoughtmechnix.licenses.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="licenses")
public class License {

    @Id
    @Column(name="license_id", nullable=false)
    private String licenseId;

    @Column(name="organization_id", nullable=false)
    private String organizationId;

    @Column(name="product_name" nullable=false)
    private String productName;

    /* 간결한 코드를 위해 나머지 삭제 */
}
