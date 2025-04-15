package com.estampaider.pedidos.controller;

import com.estampaider.pedidos.feign.ProductoClient;
import com.estampaider.pedidos.feign.UsuarioCliente;
import com.estampaider.pedidos.modelo.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PruebaController {

    @Autowired
    private ProductoClient productoClient;

    @Autowired
    private UsuarioCliente usuarioCliente;

    @GetMapping("/test")
    public String test() {
        String producto = productoClient.obtenerDetalleProducto(1L);
        UsuarioDTO usuario = usuarioCliente.obtenerUsuario(1L);
        return "Producto: " + producto + " | Usuario: " + usuario;
    }
}
