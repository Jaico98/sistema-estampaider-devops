package com.estampaider.pedidos.clientes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "usuarios-servicio")
public interface UsuarioClienteuno {
    @GetMapping("/test")
    String obtenerMensajeUsuario();
}
