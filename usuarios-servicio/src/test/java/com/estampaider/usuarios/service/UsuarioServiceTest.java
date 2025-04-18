package com.estampaider.usuarios.service;

import com.estampaider.usuarios.model.Usuario;
import com.estampaider.usuarios.repository.UsuarioRepository;
import com.estampaider.usuarios.service.impl.UsuarioServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

public class UsuarioServiceTest {

    private UsuarioRepository usuarioRepository;
    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        usuarioRepository = mock(UsuarioRepository.class);
        usuarioService = new UsuarioServiceImpl(usuarioRepository);
    }

    @Test
    void listarUsuarios_debeRetornarLista() {
        Usuario u1 = new Usuario("1",null, "usuario1", "user1", "USER");
        Usuario u2 = new Usuario("2",null, "usuario2", "user2", "ADMIN");

        when(usuarioRepository.findAll()).thenReturn(Flux.just(u1, u2));

        StepVerifier.create(usuarioService.listarUsuarios())
                .expectNext(u1)
                .expectNext(u2)
                .verifyComplete();

        verify(usuarioRepository, times(1)).findAll();
    }
}
