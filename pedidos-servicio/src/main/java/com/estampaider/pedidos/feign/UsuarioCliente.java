package com.estampaider.pedidos.feign;

import com.estampaider.pedidos.modelo.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuarios-servicio")
public interface UsuarioCliente {
    @GetMapping("/usuarios/{id}")
    UsuarioDTO obtenerUsuario(@PathVariable("id") Long id);
}
