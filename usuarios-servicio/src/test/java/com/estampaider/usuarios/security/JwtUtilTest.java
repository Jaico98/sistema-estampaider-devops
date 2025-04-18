package com.estampaider.usuarios.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class JwtUtilTest {

    @Autowired
    private JwtUtil jwtUtil;

    @Test
    void generateToken_deberiaRetornarTokenValido() {
        String token = jwtUtil.generateToken("usuario1");
        assertNotNull(token);
    }

    @Test
    void validateToken_deberiaAceptarTokenValido() {
        String token = jwtUtil.generateToken("usuario1");
        assertTrue(jwtUtil.validateToken(token));
    }

    @Test
    void getUsernameFromToken_deberiaRetornarUsuario() {
        String token = jwtUtil.generateToken("usuario1");
        String usuario = jwtUtil.getUsernameFromToken(token);
        assertEquals("usuario1", usuario);
    }
}
