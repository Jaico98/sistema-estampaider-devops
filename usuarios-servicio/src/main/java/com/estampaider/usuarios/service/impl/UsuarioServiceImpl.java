package com.estampaider.usuarios.service.impl;

import com.estampaider.usuarios.model.Usuario;
import com.estampaider.usuarios.repository.UsuarioRepository;
import com.estampaider.usuarios.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

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

    @Override
    public Mono<Usuario> registrar(Usuario usuario) {
        return usuarioRepository.save(usuario); // ✅ Implementación
    }
}
