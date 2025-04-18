package com.estampaider.pedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.estampaider.pedidos.feign")
@EnableReactiveMongoRepositories(basePackages = "com.estampaider.pedidos.repository")
public class PedidosServicioApplication {
    public static void main(String[] args) {
        SpringApplication.run(PedidosServicioApplication.class, args);
    }
}
