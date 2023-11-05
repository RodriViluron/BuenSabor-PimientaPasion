package com.PimientaPasion.Sprint4.services;

import com.PimientaPasion.Sprint4.VerPeidosClientedtos.PedidoVerDetalleDTO;
import com.PimientaPasion.Sprint4.VerPeidosClientedtos.PedidoVerPedidoDTO;
import com.PimientaPasion.Sprint4.entities.Pedido;
import com.PimientaPasion.Sprint4.entities.Producto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PedidoService extends BaseService<Pedido,Long> {

    List<PedidoVerPedidoDTO> buscarPeidosCliente(Long id, Pageable pageable)throws Exception;
    PedidoVerDetalleDTO verDetallePedido(Long id)throws Exception;
}
