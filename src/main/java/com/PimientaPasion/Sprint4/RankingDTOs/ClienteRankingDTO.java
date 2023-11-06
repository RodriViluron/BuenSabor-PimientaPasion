package com.PimientaPasion.Sprint4.RankingDTOs;


import lombok.*;



@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRankingDTO  implements Comparable {
    private int cantidadPedidos;
    private long clienteId;
    private String nombre;
    private String apellido;
    private double totalPrecioPedidos;

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
