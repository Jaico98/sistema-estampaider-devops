package com.estampaider.pedidos.controller;

import com.estampaider.pedidos.model.Pedido;
import com.estampaider.pedidos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// Esta clase expone los endpoints HTTP para manejar pedidos
@RestController
@RequestMapping("/api/pedidos") // Prefijo para todas las rutas
public class PedidoController {

    // Inyecto el servicio que ya implementé
    @Autowired
    private PedidoService pedidoService;

    // GET /api/pedidos - Listo todos los pedidos
    @GetMapping
    public Flux<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    // GET /api/pedidos/{id} - Obtengo un pedido por ID
    @GetMapping("/{id}")
    public Mono<Pedido> obtenerPedido(@PathVariable String id) {
        return pedidoService.obtenerPedidoPorId(id);
    }

    // POST /api/pedidos - Creo un nuevo pedido
    @PostMapping
    public Mono<Pedido> crearPedido(@RequestBody Pedido pedido) {
        return pedidoService.crearPedido(pedido);
    }

    // DELETE /api/pedidos/{id} - Elimino un pedido por ID
    @DeleteMapping("/{id}")
    public Mono<Void> eliminarPedido(@PathVariable String id) {
        return pedidoService.eliminarPedido(id);
    }
}
