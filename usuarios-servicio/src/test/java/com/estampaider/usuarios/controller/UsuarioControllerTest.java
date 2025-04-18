package com.estampaider.usuarios.controller;

import com.estampaider.usuarios.model.Usuario;
import com.estampaider.usuarios.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

@WebFluxTest(controllers = UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @Test
    public void testListarUsuarios() {
        Usuario u1 = new Usuario("1",null, "usuario1", "user1", "USER");
        Usuario u2 = new Usuario("2",null, "usuario2", "user2", "ADMIN");

        when(usuarioRepository.findAll()).thenReturn(Flux.just(u1, u2));

        webTestClient.get().uri("/api/usuarios")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Usuario.class)
                .hasSize(2);
    }
}
