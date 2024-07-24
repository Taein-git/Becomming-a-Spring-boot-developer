package me.taein.springbootdeveloper.config;

import lombok.RequiredArgsConstructor;
import me.taein.springbootdeveloper.config.jwt.TokenProvider;
import me.taein.springbootdeveloper.config.oauth.OAuth2UserCustomService;
import me.taein.springbootdeveloper.repository.RefreshTokenRepository;
import me.taein.springbootdeveloper.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

@RequiredArgsConstructor
@Configuration
public class WebOAuthSecurityConfig {

    private final OAuth2UserCustomService oAuth2UserCustomService;
    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final UserService userService;




}
