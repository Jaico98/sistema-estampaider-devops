package com.estampaider.pedidos.service.impl;

import com.estampaider.pedidos.modelo.Pedido;
import com.estampaider.pedidos.repository.PedidoRepository;
import com.estampaider.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    @Override
    public Flux<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Mono<Pedido> obtenerPedidoPorId(String id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public Mono<Pedido> crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Mono<Void> eliminarPedido(String id) {
        return pedidoRepository.deleteById(id);
    }
}
