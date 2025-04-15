package com.estampaider.usuarios.controller;

import com.estampaider.usuarios.security.JwtUtil;
import com.estampaider.usuarios.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");

        if (userService.validarCredenciales(username, password)) {
            String token = jwtUtil.generateToken(username);
            return Map.of("token", token);
        } else {
            throw new RuntimeException("Credenciales inválidas");
        }
    }
}
