package com.estampaider.usuarios.controller;

import com.estampaider.usuarios.model.Usuario;
import com.estampaider.usuarios.repository.UsuarioRepository;
import com.estampaider.usuarios.security.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Map;

import static org.mockito.ArgumentMatchers.any;

@WebFluxTest(AuthController.class)
@Import({JwtUtil.class}) 
public class AuthControllerTest {

    @MockBean
    private ReactiveAuthenticationManager authenticationManager;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;

    private WebTestClient webTestClient;
    private JwtUtil jwtUtil;

    @BeforeEach
    public void setUp() {
        jwtUtil = new JwtUtil();
        AuthController authController = new AuthController(jwtUtil, authenticationManager, usuarioRepository, passwordEncoder);
        webTestClient = WebTestClient.bindToController(authController).build();
    }

    @Test
    void login_DeberiaRetornarToken_ConCredencialesValidas() {
        // Arrange
        String username = "admin";
        String password = "admin";

        Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);

        Mockito.when(authenticationManager.authenticate(any(Authentication.class)))
                .thenReturn(Mono.just(authentication));

        // Act - Assert
        webTestClient.post()
                .uri("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(Map.of("username", username, "password", password))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.token").isNotEmpty();
    }

    @Test
    void register_DeberiaRegistrarUsuario_ConDatosValidos() {
        Usuario nuevo = new Usuario(null, "Nuevo", "nuevo@email.com", "1234", "USER");

        Mockito.when(usuarioRepository.findByCorreo("nuevo@email.com"))
                .thenReturn(Mono.empty());

        Mockito.when(passwordEncoder.encode("1234")).thenReturn("hashed1234");
        Mockito.when(usuarioRepository.save(any(Usuario.class))).thenReturn(Mono.just(nuevo));

        webTestClient.post()
                .uri("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(nuevo)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Usuario registrado correctamente");
    }

    @Test
    void register_DeberiaFallar_SiCorreoYaExiste() {
        Usuario existente = new Usuario("1", "Existente", "admin@email.com", "1234", "USER");

        Mockito.when(usuarioRepository.findByCorreo("admin@email.com"))
                .thenReturn(Mono.just(existente));

        webTestClient.post()
                .uri("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(existente)
                .exchange()
                .expectStatus().isBadRequest()
                .expectBody(String.class).isEqualTo("El correo ya está registrado");
    }

    @Test
    void register_DeberiaFallar_SiFaltanCampos() {
        Usuario incompleto = new Usuario(null, null, null, null, null);

        webTestClient.post()
                .uri("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(incompleto)
                .exchange()
                .expectStatus().isBadRequest()
                .expectBody(String.class).isEqualTo("Todos los campos son obligatorios");
    }
}

