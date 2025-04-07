package com.estampaider.usuarios.service;

import com.estampaider.usuarios.model.Usuario;
import com.estampaider.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Flux<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Mono<Usuario> obtenerUsuarioPorId(String id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Mono<Usuario> crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Mono<Void> eliminarUsuario(String id) {
        return usuarioRepository.deleteById(id);
    }
}
