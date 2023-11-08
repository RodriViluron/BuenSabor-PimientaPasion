package com.PimientaPasion.Sprint4.RankingDTOs;


import lombok.*;



@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRankingDTO {
    private String nombre;
    private String apellido;
    private int cantidadPedidos;
    private double totalPrecioPedidos;
}
