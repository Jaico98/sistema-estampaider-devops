package com.estampaider.pedidos.clientes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "productos-servicio")
public interface ProductoCliente {
    @GetMapping("/test")
    String obtenerMensajeProducto();
}
