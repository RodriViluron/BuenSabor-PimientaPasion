package com.PimientaPasion.Sprint4.VerPedidosDeliverydtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DireccionPedidosDeliveryDTO {
    private String calle;
    private Integer numeroDomicilio;
    private String localidad;
}
