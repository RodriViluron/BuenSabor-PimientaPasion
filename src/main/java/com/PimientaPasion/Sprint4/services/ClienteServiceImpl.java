package com.PimientaPasion.Sprint4.services;

import com.PimientaPasion.Sprint4.RankingDTOs.ClienteRankingDTO;
import com.PimientaPasion.Sprint4.entities.Cliente;
import com.PimientaPasion.Sprint4.entities.Ingrediente;
import com.PimientaPasion.Sprint4.entities.Pedido;
import com.PimientaPasion.Sprint4.repositories.BaseRepository;
import com.PimientaPasion.Sprint4.repositories.ClienteRepository;
import com.PimientaPasion.Sprint4.repositories.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
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
    @Transactional
    public List<Cliente> search(String filtro) throws Exception {
        try{
            List<Cliente> clientes = clienteRepository.search(filtro);
            return clientes;
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Page<Cliente> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<Cliente> clientes= clienteRepository.searchNativo(filtro, pageable);
            return clientes;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cliente singInCliente(String filtro1, String filtro2) throws Exception {
        try{
            Cliente cliente=clienteRepository.singInCliente(filtro1,filtro2);
            return cliente;
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void eliminarCliente(Long clienteId) throws Exception {
        try {
            //if (clienteId != null) {
            clienteRepository.eliminarCliente(clienteId);

            //}

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cliente modificarCliente(Long clienteId, String nuevoNombre, String nuevoApellido, String nuevoTelefono, String nuevoEmail) throws Exception {
        try {
            if (clienteId != null) {
                // Llama al método de repositorio para modificar el cliente por su ID
                Cliente cliente = clienteRepository.modificarCliente(clienteId, nuevoNombre, nuevoApellido, nuevoTelefono, nuevoEmail);
                return cliente;
            } else {
                return null;
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
