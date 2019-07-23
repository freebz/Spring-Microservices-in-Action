// 코드 7-12 JWT TokenEnhancer 클래스를 확장해 사용자 정의 필드 추가

package com.thoughtmechanix.authentication.security;

// 간결한 코드를 위해 import 삭제
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
public class JWTTokenEnhancer implements TokenEnhancer {
    @Autowired
    private OrgUserRepository orgUserRepo;
    private String getOrgId(String userName) {
	UserOrganization orgUser =
	    orgUserRepo.findByUserName(userName);
	return orgUser.getOrganizationId();
    }
    @Override
    public OAuth2AccessToken enchance(
	OAuth2AccessToekn accessToken,
	OAuth2Authentication authentication) {
	Map<String, Object> additionalInfo = new HashMap<>();
	String orgId = getOrgId(authentication.getName());
	additionalInfo.put("organizationId", orgId);
	((DefaultOAuth2AccessToken) accessToken)
	    .setAdditionalInformation(additionalInfo);
	return accessToken;
    }
}
