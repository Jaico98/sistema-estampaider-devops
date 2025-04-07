package com.estampaider.usuarios.controller;

import com.estampaider.usuarios.model.Usuario;
import com.estampaider.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

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
