package com.estampaider.usuarios.controller;

import com.estampaider.usuarios.model.Usuario;
import com.estampaider.usuarios.repository.UsuarioRepository;
import com.estampaider.usuarios.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtUtil jwtUtil;
    private final ReactiveAuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public Mono<Map<String, String>> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

        Authentication auth = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManager.authenticate(auth)
                .map(result -> Map.of("token", jwtUtil.generateToken(username)));
    }

    @PostMapping("/register")
    public Mono<ResponseEntity<String>> register(@RequestBody Usuario nuevoUsuario) {
        if (nuevoUsuario.getCorreo() == null || nuevoUsuario.getContrasena() == null || nuevoUsuario.getNombre() == null) {
            return Mono.just(ResponseEntity.badRequest().body("Todos los campos son obligatorios"));
        }

        return usuarioRepository.findByCorreo(nuevoUsuario.getCorreo())
                .flatMap(u -> Mono.just(ResponseEntity.badRequest().body("El correo ya está registrado")))
                .switchIfEmpty(
                    Mono.defer(() -> {
                        String hashedPassword = passwordEncoder.encode(nuevoUsuario.getContrasena());
                        nuevoUsuario.setContrasena(hashedPassword);
                        return usuarioRepository.save(nuevoUsuario)
                                .thenReturn(ResponseEntity.ok("Usuario registrado correctamente"));
                    })
                );
    }
}
