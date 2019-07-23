// 코드 8-8 라이선싱 서비스가 레디스와 어떻게 통신할지 설정

package com.thoughtmechanix.licenses;

// 간결한 코드를 위해 import 삭제

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableBinding(Sink.class)
public class Application {
    @Autowired
    private ServiceConfig serviceConfig;

    // 간결한 코드를 위해 다른 메서드 삭제

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
	JedisConnectionFactory jedisConnFactory = new JedisConnectionFactory();
	jedisConnFactory.setHostName(serviceConfig.getRedisServer());
	jedisConnFactory.setPort(serviceConfig.getRedisPort());
	return jedisConnFactory;
    }
    
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
	RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
	template.setConnectionFactory(jedisConnectionFactory());
	return template;
    }
}
