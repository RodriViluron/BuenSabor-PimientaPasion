package com.PimientaPasion.Sprint4.repositories;

import com.PimientaPasion.Sprint4.entities.RubroIngrediente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface RubroIngredienteRepository extends BaseRepository<RubroIngrediente, Long> {

    /*@Query("SELECT ri.denominacion, ri.eliminado " +
                    "FROM RubroIngrediente ri " +
                    "WHERE ri.eliminado=null"
    )
    List<RubroIngrediente> searchRubrosIngredientes();

    @Query("SELECT ri.denominacion, ri.eliminado " +
            "FROM RubroIngrediente ri " +
            "WHERE ri.id = :idRubroIngrediente AND ri.eliminado=null"
    )
    RubroIngrediente searchRubroIngredienteById(@RequestParam int idRubroIngrediente);

    @Query()
    RubroIngrediente saveRubroIngrediente();
*/
}
