package com.PimientaPasion.Sprint4.services;

import com.PimientaPasion.Sprint4.DTOs.VerPedidosClientedtos.FacturaVerFacturaDTO;
import com.PimientaPasion.Sprint4.DTOs.VerPedidosClientedtos.PedidoVerDetalleDTO;
import com.PimientaPasion.Sprint4.DTOs.VerPedidosClientedtos.PedidoVerPedidoDTO;
import com.PimientaPasion.Sprint4.DTOs.VerPedidosDeliverydtos.PedidoPedidosDeliveryDTO;
import com.PimientaPasion.Sprint4.entities.Pedido;
import com.PimientaPasion.Sprint4.enums.EstadoPedido;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PedidoService extends BaseService<Pedido,Long> {

    List<PedidoVerPedidoDTO> buscarPedidosCliente(Long id, Pageable pageable)throws Exception;
    PedidoVerDetalleDTO verDetallePedido(Long id)throws Exception;
    FacturaVerFacturaDTO verFacturaPedido(Long id) throws Exception;
    List<PedidoPedidosDeliveryDTO> buscarPedidoPorEstado(EstadoPedido pedido_estado)throws Exception;

}
