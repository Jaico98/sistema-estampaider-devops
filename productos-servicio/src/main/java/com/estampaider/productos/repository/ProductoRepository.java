package com.estampaider.productos.repository;

import com.estampaider.productos.model.Producto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

// Aquí extiendo ReactiveMongoRepository para poder usar Mongo de forma reactiva.
public interface ProductoRepository extends ReactiveMongoRepository<Producto, String> {
}
