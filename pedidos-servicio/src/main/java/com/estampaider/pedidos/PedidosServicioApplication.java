package com.estampaider.pedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.estampaider.pedidos.feign")
public class PedidosServicioApplication {
    public static void main(String[] args) {
        SpringApplication.run(PedidosServicioApplication.class, args);
    }
}
