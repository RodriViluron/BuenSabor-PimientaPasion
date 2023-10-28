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
    List<Empleado> search(@Param("filtro") String filtro);
    @Query(value = "SELECT e FROM Empleado e WHERE e.nombre LIKE %:filtro% OR e.apellido LIKE %:filtro%")
    Page<Empleado> search(@Param("filtro") String filtro, Pageable pageable);


    //Query de inicio de sesion empleado
    @Query(
            value="select e from Empleado e where e.usuario.username like %:filtro1% and e.usuario.contraseña like %:filtro2%")
    Empleado singInEmpleado (@Param("filtro1") String filtro1,@Param("filtro2") String filtro2);


}
