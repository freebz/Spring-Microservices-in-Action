// 코드 3-9 애플리케이션 프로퍼티를 한곳으로 모으는 ServiceConfig

package com.thoughtmechnix.licenses.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfig {
    @Value("${example.property}")
    private String exampleProperty;

    public String getExampleProperty() {
	return exampleProperty;
    }
}
