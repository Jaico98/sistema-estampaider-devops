package com.estampaider.pedidos.repository;

import com.estampaider.pedidos.modelo.Pedido;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends ReactiveMongoRepository<Pedido, String> {
}
