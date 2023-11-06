package com.PimientaPasion.Sprint4.VerPedidosClientedtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleFacturaVerFacturaDTO {
    private Integer cantidad;

    private double subtotal;
    private ProductoVerDatalleDTO productoVerDatalleDTO;

}
