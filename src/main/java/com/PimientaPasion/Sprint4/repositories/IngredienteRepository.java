package com.PimientaPasion.Sprint4.repositories;
import com.PimientaPasion.Sprint4.entities.Ingrediente;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredienteRepository extends BaseRepository<Ingrediente, Long> {

    @Query(value = "SELECT i FROM Ingrediente i WHERE i.denominacion LIKE %:filtro%")
    List<Ingrediente> search(@Param("filtro") String filtro);

    @Query(value = "SELECT i FROM Ingrediente i WHERE i.denominacion LIKE %:filtro%")
    Page<Ingrediente> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM ingrediente WHERE ingrediente.denominacion LIKE %:filtro%",
            nativeQuery = true
    )
    List<Ingrediente> searchNativo(@Param("filtro") String filtro);
    @Query(
            value = "SELECT * FROM ingrediente WHERE ingrediente.denominacion LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM articuloInsumo",
            nativeQuery = true
    )
    Page<Ingrediente> searchNativo(@Param("filtro") String filtro, Pageable pageable);

}
