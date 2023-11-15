package com.PimientaPasion.BuenSabor.services;

import com.PimientaPasion.BuenSabor.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductoService extends BaseService<Producto, Long>{
    List<Producto> buscarPorDenominacion( String denominacion)throws Exception;
    Page<Producto> buscarPorDenominacion(String denominacion, Pageable pageable) throws Exception;

    List<Producto> buscarDisponibles()throws Exception;
}
