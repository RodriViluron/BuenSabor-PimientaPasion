package com.PimientaPasion.Sprint4.services;

import com.PimientaPasion.Sprint4.entities.RubroProducto;

import java.util.List;

public interface RubroProductoService extends BaseService<RubroProducto,Long> {

    List<RubroProducto> buscarRubrosProdDisponibles() throws Exception;
}
