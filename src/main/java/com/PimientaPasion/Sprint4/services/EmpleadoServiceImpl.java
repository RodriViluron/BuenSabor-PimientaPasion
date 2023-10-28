package com.PimientaPasion.Sprint4.services;

import com.PimientaPasion.Sprint4.entities.Empleado;
import com.PimientaPasion.Sprint4.repositories.BaseRepository;

import com.PimientaPasion.Sprint4.repositories.EmpleadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl extends BaseServiceImpl<Empleado,Long> implements EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(BaseRepository<Empleado, Long> baseRepository, EmpleadoRepository empleadoRepository) {
        super(baseRepository);
    }

    @Override
    @Transactional
    public List<Empleado> search(String filtro) throws Exception {
        try{
            List<Empleado> empleados = empleadoRepository.search(filtro);
            return empleados;
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Page<Empleado> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<Empleado> empleados= empleadoRepository.search(filtro,pageable);
            return empleados;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Empleado singInEmpleado(String filtro1, String filtro2) throws Exception {
        try {
            Empleado empleado=empleadoRepository.singInEmpleado(filtro1,filtro2);
            return empleado;
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
