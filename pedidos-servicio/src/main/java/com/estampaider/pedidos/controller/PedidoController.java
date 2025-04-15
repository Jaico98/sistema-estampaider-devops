package com.estampaider.pedidos.controller;

import com.estampaider.pedidos.modelo.Pedido;
import com.estampaider.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/pedidos") // Debe coincidir con el path configurado en Gateway
@RequiredArgsConstructor
public class PedidoController {

    @Autowired
    private final PedidoService pedidoService;

    @GetMapping
    public Flux<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    @GetMapping("/{id}")
    public Mono<Pedido> obtenerPedido(@PathVariable String id) {
        return pedidoService.obtenerPedidoPorId(id);
    }

    @PostMapping
    public Mono<Pedido> crearPedido(@RequestBody Pedido pedido) {
        return pedidoService.crearPedido(pedido);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminarPedido(@PathVariable String id) {
        return pedidoService.eliminarPedido(id);
    }
}
