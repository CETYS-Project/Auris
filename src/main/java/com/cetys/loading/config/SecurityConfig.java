package com.cetys.loading.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Value("https://auris-identifier")
    private String audience;

    @Value("https://dev-aodesvgtpd08tn2z.us.auth0.com/")
    private String issuer;

    @Value("http://localhost:3000")
    private String corsAllowedOrigins;

    @Value("false")
    boolean webSecurityDebug;
}
