package com.estampaider.usuarios.controller;

import com.estampaider.usuarios.model.Usuario;
import com.estampaider.usuarios.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Map;

@SpringBootTest
@AutoConfigureWebTestClient
class AuthControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        usuarioRepository.deleteAll().block();
    }

    private String obtenerToken(String username, String rawPassword) {
        Usuario usuario = new Usuario();
        usuario.setNombre(username);
        usuario.setCorreo(username + "@test.com");
        usuario.setContrasena(passwordEncoder.encode(rawPassword));
        usuarioRepository.save(usuario).block();

        Map<String, String> credentials = Map.of("username", username, "password", rawPassword);
        return webTestClient.post().uri("/auth/login")
                .bodyValue(credentials)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Map.class)
                .returnResult()
                .getResponseBody()
                .get("token")
                .toString();
    }

    @Test
    void register_deberiaCrearNuevoUsuario() {
        String token = obtenerToken("adminuser", "adminpass");

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre("nuevo");
        nuevoUsuario.setCorreo("nuevo@test.com");
        nuevoUsuario.setContrasena("12345");

        webTestClient.post()
                .uri("/auth/register")
                .header("Authorization", "Bearer " + token)
                .bodyValue(nuevoUsuario)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("Usuario registrado correctamente");
    }

    @Test
    void register_deberiaRechazarCorreoDuplicado() {
        Usuario usuarioExistente = new Usuario();
        usuarioExistente.setNombre("existente");
        usuarioExistente.setCorreo("correo@ya.com");
        usuarioExistente.setContrasena(passwordEncoder.encode("123"));
        usuarioRepository.save(usuarioExistente).block();

        String token = obtenerToken("adminuser2", "adminpass2");

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre("nuevo");
        nuevoUsuario.setCorreo("correo@ya.com"); // Correo duplicado
        nuevoUsuario.setContrasena("12345");

        webTestClient.post()
                .uri("/auth/register")
                .header("Authorization", "Bearer " + token)
                .bodyValue(nuevoUsuario)
                .exchange()
                .expectStatus().isBadRequest()
                .expectBody(String.class)
                .isEqualTo("El correo ya está registrado");
    }
}
