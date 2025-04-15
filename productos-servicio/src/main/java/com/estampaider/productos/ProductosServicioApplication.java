package com.estampaider.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductosServicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductosServicioApplication.class, args);
	}

}
