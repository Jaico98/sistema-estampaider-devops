package com.estampaider.pedidos.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estampaider.pedidos.clientes.ProductoCliente;
import com.estampaider.pedidos.clientes.UsuarioClienteuno;

@RestController
public class PruebaControlleruno {

    private final UsuarioClienteuno usuarioCliente;
    private final ProductoCliente productoCliente;

    public PruebaControlleruno(UsuarioClienteuno usuarioCliente, ProductoCliente productoCliente) {
        this.usuarioCliente = usuarioCliente;
        this.productoCliente = productoCliente;
    }

    @GetMapping("/test")
    public String test() {
        String usuario = usuarioCliente.obtenerMensajeUsuario();
        String producto = productoCliente.obtenerMensajeProducto();
        return "PEDIDOS-SERVICIO FUNCIONANDO ✅\n→ " + usuario + "\n→ " + producto;
    }
}
