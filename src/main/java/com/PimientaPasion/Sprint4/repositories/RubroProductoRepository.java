package com.PimientaPasion.Sprint4.repositories;

import com.PimientaPasion.Sprint4.entities.RubroProducto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RubroProductoRepository extends BaseRepository<RubroProducto, Long> {


    //Query para presentar productos en el menu
    @Query("select rp from RubroProducto  rp where rp.eliminado=false OR rp.eliminado=null")
    List<RubroProducto> buscarRubrosProdDisponibles();



}
