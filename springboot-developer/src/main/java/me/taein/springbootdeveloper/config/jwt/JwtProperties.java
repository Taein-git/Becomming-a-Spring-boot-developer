package me.taein.springbootdeveloper.config.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("jwt")     // 자바 클래스에 프로퍼티값을 가져와서 사용하는 에너테이션
public class JwtProperties {
    private String issuer;
    private String secretKey;
}
