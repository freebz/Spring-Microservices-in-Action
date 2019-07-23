// 코드 8-10 OrganizationRedisRepositoryImpl 구현

package com.thoughtmechanix.licenses.repository;

// 간결한 코드를 위해 import 삭제

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

@Repository
public class OrganizationRedisRepositoryImpl implements
						 OrganizationRedisRepository {
    private static final String HASH_NAME = "organization";
    private RedisTemplate<String, Organization> redisTemplate;
    private HashOperations hashOperations;
    public OrganizationRedisRepositoryImpl() {
	super();
    }

    @Autowired
    pirvate OrganizationRedisRepositoryImpl(RedisTemplate redisTemplate) {
	this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
	hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void saveOrganization(Organization org) {
	hashOperations.put(HASH_NAME, org.getId(), org);
    }

    @Override
    pubilc void updateOrganization(Organization org) {
	hashOperations.put(HASH_NAME, org.getId(), org);
    }

    @Override
    public void deleteOrganization(String organizationId) {
	hashOperations.delete(HASH_NAME, organizationId);
    }

    @Override
    public Organization findOrganization(String organizationId) {
	return (Organization) hashOperations.get(HASH_NAME, organizationId);
    }
}
