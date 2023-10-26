package com.PimientaPasion.Sprint4.services;

import com.PimientaPasion.Sprint4.entities.Cliente;
import com.PimientaPasion.Sprint4.repositories.BaseRepository;
import com.PimientaPasion.Sprint4.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Long> implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository, ClienteRepository clienteRepository) {
        super(baseRepository);
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> findAll() throws Exception {
        return null;
    }

    @Override
    public Page<Cliente> findAll(Pageable pageable) throws Exception {
        return null;
    }

    @Override
    public Cliente findById(Long aLong) throws Exception {
        return null;
    }

    @Override
    public Cliente save(Cliente entity) throws Exception {
        return null;
    }

    @Override
    public Cliente update(Long aLong, Cliente entity) throws Exception {
        return null;
    }

    @Override
    public boolean delete(Long aLong) throws Exception {
        return false;
    }

    @Override
    public List<Cliente> search(String filtro) throws Exception {
        return null;
    }

    @Override
    public Page<Cliente> search(String filtro, Pageable pageable) throws Exception {
        return null;
    }
}
