package com.PimientaPasion.Sprint4.repositories;

import com.PimientaPasion.Sprint4.entities.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long> {
    @Query(
            value = "SELECT * FROM usuario WHERE usuario.username LIKE %:filtro% ",
            nativeQuery = true
    )
    List<Usuario> searchNativo(@Param("filtro") String filtro);
}
