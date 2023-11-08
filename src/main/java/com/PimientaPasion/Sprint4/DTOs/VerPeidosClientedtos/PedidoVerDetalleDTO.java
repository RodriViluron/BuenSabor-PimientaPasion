package com.PimientaPasion.Sprint4.DTOs.VerPeidosClientedtos;

import com.PimientaPasion.Sprint4.enums.FormaPago;
import com.PimientaPasion.Sprint4.enums.TipoEnvio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoVerDetalleDTO {
    private Long id;
    private Date fechaPedido;
    private double totalPedido;
    private FormaPago formaPago;
    private TipoEnvio tipoEnvio;
    private List<DetallePedidoVerDetalleDTO> detallePedidoVerDetalleDTOS;
}
