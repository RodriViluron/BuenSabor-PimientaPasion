package com.PimientaPasion.Sprint4.services;

import com.PimientaPasion.Sprint4.entities.Producto;
import com.PimientaPasion.Sprint4.repositories.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductoServiceImplTest {
    @MockBean
    private ProductoRepository productoRepository;
    @Autowired
    private ProductoServiceImpl productoService;

    @Test
    void buscarPorDenominacion() throws Exception{
        Producto producto=Producto.builder()
                .denominacion("Hamburgesa")
                .build();

        List<Producto> productos=new ArrayList<Producto>();
        productos.add(producto);

        when(productoRepository.buscarPorDenominacion("Hamburgesa")).thenReturn(productos);
        assertEquals(productos, productoService.buscarPorDenominacion("Hamburgesa"));
    }

    @Test
    void testBuscarPorDenominacion() throws Exception{
        Producto producto=Producto.builder()
                .denominacion("Hamburgesa")
                .build();

        List<Producto> productos=new ArrayList<Producto>();
        productos.add(producto);
        Page<Producto> productosPage = new PageImpl<>(productos, PageRequest.of(0, 5), 1);

        when(productoRepository.buscarPorDenominacion("Hamburgesa",PageRequest.of(0, 5))).thenReturn(productosPage);
        assertEquals(productosPage,productoService.buscarPorDenominacion("Hamburgesa",PageRequest.of(0, 5)));
    }

    @Test
    void buscarDisponibles() throws Exception{
        Producto producto1=Producto.builder()
                .denominacion("Hamburgesa")
                .eliminado(false)
                .build();
        Producto producto2=Producto.builder()
                .denominacion("Lomo")
                .eliminado(true)
                .build();



        List<Producto> productos=new ArrayList<Producto>();
        productos.add(producto1);

        when(productoRepository.buscarDisponibles()).thenReturn(productos);
        assertEquals(productos,productoService.buscarDisponibles());

    }
}