package com.estampaider.usuarios.controller;

import com.estampaider.usuarios.model.Usuario;
import com.estampaider.usuarios.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*") // Permite llamadas desde cualquier origen (útil para frontends)
@Validated
@RestController
@RequestMapping("/api/usuarios") // Esto debe coincidir con la ruta en el Gateway
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public Flux<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Mono<Usuario> obtenerUsuario(@PathVariable String id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    @PostMapping
    public Mono<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.crearUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminarUsuario(@PathVariable String id) {
        return usuarioService.eliminarUsuario(id);
    }
}
