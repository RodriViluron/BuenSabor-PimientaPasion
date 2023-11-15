package com.PimientaPasion.BuenSabor.DTOs;


import lombok.*;



@Data

public class ClienteRankingDTO {
    private String nombre;
    private String apellido;
    private int cantidadPedidos;
    private double totalPrecioPedidos;

    public ClienteRankingDTO(String nombre, String apellido, int cantidadPedidos, double totalPrecioPedidos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cantidadPedidos = cantidadPedidos;
        this.totalPrecioPedidos = totalPrecioPedidos;
    }
}
