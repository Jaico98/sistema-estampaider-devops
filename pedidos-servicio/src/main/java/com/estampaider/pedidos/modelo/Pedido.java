package com.estampaider.pedidos.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pedidos")
public class Pedido {

    @Id
    private String id;

    private String usuarioId;
    private String producto;
    private int cantidad;
    private double precio;
}
