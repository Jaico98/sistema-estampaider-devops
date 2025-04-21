package com.estampaider.productos.model;

public class UsuarioDTD {
    private Long id;
    private String nombre;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Para imprimirlo en texto
    @Override
    public String toString() {
        return "UsuarioDTO{id=" + id + ", nombre='" + nombre + "'}";
    }
}
