package com.estampaider.usuarios.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PruebaController {

    @GetMapping("/test")
    public String test() {
        return "Microservicio de usuarios funcionando correctamente ✅";
    }
}
