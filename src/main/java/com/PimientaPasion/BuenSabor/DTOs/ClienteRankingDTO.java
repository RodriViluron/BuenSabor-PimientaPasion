package com.PimientaPasion.BuenSabor.DTOs;


import lombok.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRankingDTO {
    private String nombre;
    private String apellido;
    private int cantidadPedidos;
    private double totalPrecioPedidos;

}
