package com.PimientaPasion.Sprint4.repositories;

import com.PimientaPasion.Sprint4.entities.Cliente;
import com.PimientaPasion.Sprint4.entities.Empleado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends BaseRepository<Empleado, Long> {

    @Query(value = "SELECT e FROM Empleado e WHERE e.nombre LIKE %:filtro% OR e.apellido LIKE %:filtro%")
    List<Cliente> search(@Param("filtro") String filtro);
    @Query(value = "SELECT e FROM Empleado e WHERE e.nombre LIKE %:filtro% OR e.apellido LIKE %:filtro%")
    Page<Cliente> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM empleado WHERE empleado.nombre LIKE %:filtro% OR empleado.apellido LIKE %:filtro%",
            nativeQuery = true
    )
    List<Cliente> searchNativo(@Param("filtro") String filtro);
    @Query(
            value = "SELECT * FROM empleado WHERE empleado.nombre LIKE %:filtro% OR empleado.apellido LIKE %:filtro%",
            countQuery = "SELECT count (*) FROM empleado",
            nativeQuery = true
    )
    Page<Cliente> searchNativo(@Param("filtro") String filtro, Pageable pageable);

}
