package com.estampaider.pedidos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping("/ping")
    public String ping() {
        return "Pedidos-servicio funcionando ✅";
    }
}
