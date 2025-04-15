package com.estampaider.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/web")
public class WebController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/productos")
    public String obtenerProductos() {
        // Usa el nombre registrado en Eureka
        String url = "http://productos-servicio/api/productos";
        return restTemplate.getForObject(url, String.class);
    }
}
