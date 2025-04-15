package com.estampaider.pedidos.service;

import com.estampaider.pedidos.modelo.Pedido;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// Esta es la interfaz que define lo que debe hacer el servicio de pedidos.
// sa uso para separar la lógica del negocio de la implementación.
public interface PedidoService {

    // Método para listar todos los pedidos
    Flux<Pedido> listarPedidos();

    // Método para obtener un pedido por su ID
    Mono<Pedido> obtenerPedidoPorId(String id);

    // Método para crear un nuevo pedido
    Mono<Pedido> crearPedido(Pedido pedido);

    // Método para eliminar un pedido
    Mono<Void> eliminarPedido(String id);
}
