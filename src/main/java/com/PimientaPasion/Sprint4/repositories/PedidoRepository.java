package com.PimientaPasion.Sprint4.repositories;

import com.PimientaPasion.Sprint4.entities.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido,Long> {

    //HU#13 Cliente Visualiza Pedidos (paginado y con DTO)
    @Query("select p from Pedido p where p.cliente.id = :id_cliente")
    Page <Pedido> buscarPeidosCliente (@Param("id_cliente") Long id_cliente, Pageable pageable);

    //HU#13 Cliente Visualiza el Detalle Un Pedido
    @Query("select p from  Pedido p where p.id=:id_pedido")
    Pedido verDetallePedido (@Param("id_pedido")Long id_pedido);
}