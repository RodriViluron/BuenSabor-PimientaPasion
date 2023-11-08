package com.PimientaPasion.Sprint4.DTOs.VerPeidosClientedtos;

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
