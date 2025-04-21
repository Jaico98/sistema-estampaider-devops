package com.estampaider.pedidos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

    private final JwtSecurityContextRepository jwtSecurityContextRepository;

    public SecurityConfig(JwtSecurityContextRepository jwtSecurityContextRepository) {
        this.jwtSecurityContextRepository = jwtSecurityContextRepository;
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeExchange(exchange -> exchange
                        .pathMatchers("/auth/**").permitAll()
                        .pathMatchers("/actuator/**").permitAll()
                        .anyExchange().authenticated()
                )
                .securityContextRepository(jwtSecurityContextRepository)
                .build();
    }
}
