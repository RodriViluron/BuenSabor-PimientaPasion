package com.PimientaPasion.Sprint4.services;


import com.PimientaPasion.Sprint4.entities.Cliente;
import com.PimientaPasion.Sprint4.entities.Empleado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmpleadoService extends BaseService <Empleado,Long> {

    List<Empleado> search(String filtro) throws Exception;

    Page<Empleado> search(String filtro, Pageable pageable) throws Exception;

    Empleado singInEmpleado (String filtro1, String filtro2) throws Exception;

}
