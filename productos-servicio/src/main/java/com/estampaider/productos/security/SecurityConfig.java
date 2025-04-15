package com.estampaider.productos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

    private final JwtUtil jwtUtil;

    public SecurityConfig(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .csrf().disable()
                .securityContextRepository(new JwtSecurityContextRepository(jwtUtil))
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/public/**").permitAll()
                        .anyExchange().authenticated()
                )
                .build();
    }
}
