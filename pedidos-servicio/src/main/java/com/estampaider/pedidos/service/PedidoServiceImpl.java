package com.estampaider.pedidos.service;

import com.estampaider.pedidos.model.Pedido;
import com.estampaider.pedidos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// Esta clase es la implementación real del servicio.
// Aquí es donde realmente hago las operaciones con el repositorio.
@Service
public class PedidoServiceImpl implements PedidoService {

    // Inyecto el repositorio de pedidos usando @Autowired
    @Autowired
    private PedidoRepository pedidoRepository;

    // Listo todos los pedidos que hay en la base de datos
    @Override
    public Flux<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    // Busco un pedido por su ID
    @Override
    public Mono<Pedido> obtenerPedidoPorId(String id) {
        return pedidoRepository.findById(id);
    }

    // Guardo un nuevo pedido en la base de datos
    @Override
    public Mono<Pedido> crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    // Elimino un pedido por su ID
    @Override
    public Mono<Void> eliminarPedido(String id) {
        return pedidoRepository.deleteById(id);
    }
}
