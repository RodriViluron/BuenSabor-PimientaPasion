package com.PimientaPasion.BuenSabor.repositories;

import com.PimientaPasion.BuenSabor.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends BaseRepository<Producto, Long> {
    @Query("SELECT p FROM Producto p WHERE p.denominacion like %:denominacion%")
    List<Producto> buscarPorDenominacion(@Param("denominacion") String denominacion);

    @Query("SELECT p FROM Producto p WHERE p.denominacion like %:denominacion%")
    Page<Producto> buscarPorDenominacion(@Param("denominacion") String denominacion, Pageable pageable);

    //Query para traer los producto disponiles
    @Query("select p from Producto  p where p.eliminado=false OR p.eliminado=null")
    List<Producto> buscarDisponibles ();


}
