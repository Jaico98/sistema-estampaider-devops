package com.estampaider.pedidos.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.estampaider.pedidos.modelo.Pedido;

// Uso @Repository para que Spring lo reconozca como un componente de acceso a datos
@Repository
public interface PedidoRepository extends ReactiveCrudRepository<Pedido, String> {
    // Heredo de ReactiveCrudRepository para tener funciones reactivas como:
    // findAll(), findById(), save(), deleteById(), etc.
}
