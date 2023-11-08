package com.PimientaPasion.Sprint4.services;

import com.PimientaPasion.Sprint4.RankingDTOs.ClienteRankingDTO;
import com.PimientaPasion.Sprint4.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface ClienteService extends BaseService<Cliente,Long>{
    List<Cliente> search(String filtro) throws Exception;

    Page<Cliente> search(String filtro, Pageable pageable) throws Exception;

    Cliente singInCliente (String filtro1, String filtro2) throws Exception;

    void eliminarCliente (Long clienteId) throws Exception;

    Cliente modificarCliente(Long clienteId, String nuevoNombre, String nuevoApellido, String nuevoTelefono, String nuevoEmail) throws Exception;
}
