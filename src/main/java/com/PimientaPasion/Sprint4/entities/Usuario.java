package com.PimientaPasion.Sprint4.entities;

import com.PimientaPasion.Sprint4.enums.Rol;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "usuario")
@Builder

public class Usuario extends Base {

    @NotNull
    @Column(name = "auth0_id", nullable = false, unique = true)
    private String auth0Id;

    @NotNull
    @Column(name = "username", nullable = false)
    private String username;

    private boolean eliminado;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Rol rol;


}