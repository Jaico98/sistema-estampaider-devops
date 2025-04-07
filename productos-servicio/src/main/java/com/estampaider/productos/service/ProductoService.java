package com.estampaider.productos.service;

import com.estampaider.productos.model.Producto;
import com.estampaider.productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// Este servicio lo implementé para centralizar la lógica de negocio de productos.
@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Listo todos los productos
    public Flux<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    // Obtengo un producto por su ID
    public Mono<Producto> obtenerProductoPorId(String id) {
        return productoRepository.findById(id);
    }

    // Guardo un nuevo producto
    public Mono<Producto> crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Elimino un producto
    public Mono<Void> eliminarProducto(String id) {
        return productoRepository.deleteById(id);
    }
}
