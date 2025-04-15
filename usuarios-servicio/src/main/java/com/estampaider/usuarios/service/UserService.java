package com.estampaider.usuarios.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public boolean validarCredenciales(String username, String password) {
        return username.equals("admin") && password.equals("1234");
    }
}

