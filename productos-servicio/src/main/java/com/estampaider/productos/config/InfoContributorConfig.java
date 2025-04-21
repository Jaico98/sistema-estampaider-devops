package com.estampaider.productos.config;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class InfoContributorConfig {

    @Bean
    public InfoContributor infoContributor() {
        return builder -> builder.withDetails(Map.of(
            "info.app.name", "productos-servicio",
            "info.app.description", "Microservicio para gestión de productos en Estampaider",
            "info.app.version", "1.0.0",
            "info.dev.nombre", "Jaider Andrés Correa Salcedo",
            "info.dev.email", "jaider.correa.8303@miremington.edu.co"
        ));
    }
}
