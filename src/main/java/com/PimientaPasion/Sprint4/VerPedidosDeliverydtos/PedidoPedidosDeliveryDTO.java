package com.PimientaPasion.Sprint4.VerPedidosDeliverydtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoPedidosDeliveryDTO {
    private Long id;
    private ClientePedidosDeliveyDTO clientePedidosDeliveyDTO;
    private DireccionPedidosDeliveryDTO direccionPedidosDeliveryDTO;

}
