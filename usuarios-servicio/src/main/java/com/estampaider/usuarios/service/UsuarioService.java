package com.estampaider.usuarios.service;

import com.estampaider.usuarios.model.Usuario;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UsuarioService {
    Flux<Usuario> listarUsuarios();

    Mono<Usuario> obtenerUsuarioPorId(String id);

    Mono<Usuario> crearUsuario(Usuario usuario);

    Mono<Void> eliminarUsuario(String id);
}
