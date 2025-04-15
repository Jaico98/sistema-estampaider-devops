package com.estampaider.pedidos;

import com.estampaider.pedidos.feign.ProductoClient;
import com.estampaider.pedidos.feign.UsuarioCliente;
import com.estampaider.pedidos.modelo.UsuarioDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@ActiveProfiles("test")
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class PedidosServicioApplicationTests {

    @MockBean
    private ProductoClient productoClient;

    @MockBean
    private UsuarioCliente usuarioCliente;

    @Test
    void contextLoads() {
        // Simula respuesta del ProductoClient
        Mockito.when(productoClient.obtenerDetalleProducto(Mockito.anyLong()))
               .thenReturn("Producto simulado");

        // Simula respuesta del UsuarioCliente
        UsuarioDTO usuarioSimulado = new UsuarioDTO();
        usuarioSimulado.setId(1L);
        usuarioSimulado.setNombre("Usuario simulado");

        Mockito.when(usuarioCliente.obtenerUsuario(Mockito.anyLong()))
               .thenReturn(usuarioSimulado);

        System.out.println("Contexto cargado correctamente con Feign Clients mockeados.");
    }
}

