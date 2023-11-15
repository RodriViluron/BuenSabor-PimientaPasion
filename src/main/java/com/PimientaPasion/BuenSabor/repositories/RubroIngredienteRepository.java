package com.PimientaPasion.BuenSabor.repositories;

import com.PimientaPasion.BuenSabor.entities.RubroIngrediente;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroIngredienteRepository extends BaseRepository<RubroIngrediente, Long> {
/*
    @Query("SELECT ri.denominacion, ri.eliminado " +
                    "FROM RubroIngrediente ri " +
                    "WHERE ri.eliminado=null"
    )
    List<RubroIngrediente> searchRubrosIngredientes();

    @Query("SELECT ri.denominacion, ri.eliminado " +
            "FROM RubroIngrediente ri " +
            "WHERE ri.id = :idRubroIngrediente AND ri.eliminado=null"
    )
    RubroIngrediente searchRubroIngredienteById(@RequestParam Long idRubroIngrediente);

    @Query("UPDATE RubroProducto set denominacion = :denominacion WHERE id = :idRubroIngrediente")
    void modificarRubroProducto(@RequestParam(name = "denominacion") String denominacion, @RequestParam(name = "idRubroIngrediente") Long idRubroIngrediente );
*/
}

