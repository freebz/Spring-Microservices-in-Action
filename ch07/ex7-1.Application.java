// 코드 7-1 authentication-service의 부트스트랩 클래스

// 간결한 코드를 위해 import 삭제

@SpringBootApplication
@RestController
@EnableResourceServer
@EnableAuthorizationServer
public class Application {
    @RequestMapping(value={"/user"}, produces="application/json")
    public Map<String, Object> user(OAuth2Authentication user) {
	Map<String, Object> userInfo = new HashMap<>();
	userInfo.put("user", user.getUserAuthntication().getPrincipal());
	userInfo.put("authorities",
		     AuthorityUtils.authorityListToSet(user.getUserAuthntication().getAuthorities()));
	return userInfo;
    }

    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
    }
}
