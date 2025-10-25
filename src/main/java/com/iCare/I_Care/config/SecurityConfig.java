package com.iCare.I_Care.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${secret.header.key}")
    private String secretKeyForHeader;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf -> csrf.disable())  // disable CSRF for APIs
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers(request -> secretKeyForHeader.equals(request.getHeader("X-Secret-Key")))
                                .permitAll()
                                .requestMatchers("/v3/**").permitAll()
                                .requestMatchers("/swagger-ui/**").permitAll()
                                .anyRequest().denyAll()
                );

        return httpSecurity.build();
    }
}
