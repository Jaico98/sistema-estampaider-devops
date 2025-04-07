package com.estampaider.pedidos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Le indico a Spring que esta clase representa un documento de MongoDB
@Document(collection = "pedidos")
public class Pedido {

    // Este es el identificador único del pedido, lo genera automáticamente MongoDB
    @Id
    private String id;

    // Aquí guardo el ID del usuario que hace el pedido
    private String usuarioId;

    // Aquí especifico el nombre del producto pedido
    private String producto;

    // Esta variable guarda la cantidad de productos solicitados
    private int cantidad;

    // Este campo almacena el precio total del pedido
    private double precio;

    // Constructor vacío, requerido por Spring y MongoDB
    public Pedido() {
    }

    // Este constructor lo uso cuando quiero crear un pedido rápidamente desde
    // código
    public Pedido(String usuarioId, String producto, int cantidad, double precio) {
        this.usuarioId = usuarioId;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getters y Setters para acceder y modificar los datos del pedido

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
