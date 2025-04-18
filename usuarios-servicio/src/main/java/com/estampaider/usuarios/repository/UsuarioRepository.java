package com.estampaider.usuarios.repository;

import com.estampaider.usuarios.model.Usuario;

import reactor.core.publisher.Mono;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends ReactiveMongoRepository<Usuario, String> {
    Mono<Usuario> findByCorreo(String correo);

    // Métodos como buscar por correo, etc.
}
