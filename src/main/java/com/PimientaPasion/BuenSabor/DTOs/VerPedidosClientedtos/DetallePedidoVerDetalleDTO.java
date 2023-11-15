package com.PimientaPasion.BuenSabor.DTOs.VerPedidosClientedtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedidoVerDetalleDTO {
    private double subtotal;
    private Integer cantidad;
    private ProductoVerDatalleDTO productoVerDatalleDTO;

}
