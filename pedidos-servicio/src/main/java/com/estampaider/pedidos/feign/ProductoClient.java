package com.estampaider.pedidos.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "productos-servicio")
public interface ProductoClient {
    @GetMapping("/productos/{id}")
    String obtenerDetalleProducto(@PathVariable("id") Long id);
}
