package com.PimientaPasion.Sprint4.repositories;

import com.PimientaPasion.Sprint4.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends BaseRepository<Producto, Long> {
    @Query("SELECT p FROM Producto p WHERE p.denominacion = :denominacion")
    List<Producto> buscarPorDenominacion(@Param("denominacion") String denominacion);

    @Query("SELECT p FROM Producto p WHERE p.denominacion = :denominacion")
    Page<Producto> buscarPorDenominacion(@Param("denominacion") String denominacion, Pageable pageable);



}
