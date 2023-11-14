package com.PimientaPasion.Sprint4.services;

import com.PimientaPasion.Sprint4.DTOs.ClienteRankingDTO;
import com.PimientaPasion.Sprint4.entities.Cliente;
import com.PimientaPasion.Sprint4.repositories.BaseRepository;
import com.PimientaPasion.Sprint4.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        try {
            List<Cliente> clientes = clienteRepository.search(filtro);
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Page<Cliente> search(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Cliente> clientes = clienteRepository.searchNativo(filtro, pageable);
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cliente singInCliente(String filtro1, String filtro2) throws Exception {
        try {
            Cliente cliente = clienteRepository.singInCliente(filtro1, filtro2);
            return cliente;
        } catch (Exception e) {
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

    public Cliente modificarCliente(Long clienteId, String nuevoNombre, String nuevoApellido, String nuevoTelefono, String nuevoEmail) throws Exception {
        try {
            if (clienteId != null) {
                // Obtener el cliente actual
                Cliente cliente = clienteRepository.findById(clienteId).orElse(null);

                // Verificar si el cliente existe
                if (cliente != null) {
                    // Actualizar solo los campos que no son nulos
                    if (nuevoNombre != null) {
                        cliente.setNombre(nuevoNombre);
                    }
                    if (nuevoApellido != null) {
                        cliente.setApellido(nuevoApellido);
                    }
                    if (nuevoTelefono != null) {
                        cliente.setTelefono(nuevoTelefono);
                    }
                    if (nuevoEmail != null) {
                        cliente.setEmail(nuevoEmail);
                    }

                    // Guardar los cambios en el repositorio
                    clienteRepository.save(cliente);

                    return cliente;
                } else {
                    // Cliente no encontrado
                    return null;
                }
            } else {
                // ID de cliente nulo
                return null;
            }
        } catch (Exception e) {
            throw new Exception("Error al modificar el cliente: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<ClienteRankingDTO> searchMejoresClientes(Date fechaInicio, Date fechaFin) throws Exception {
        try {
            //sin ideas la verdad
            List<Object[]> results = clienteRepository.searchMejoresClientes(fechaInicio, fechaFin);
            List<ClienteRankingDTO> rankingDTOs = new ArrayList<>();

            for (Object[] result : results) {
                String nombre = (String) result[0];
                String apellido = (String) result[1];
                int cantidadPedidos = (int) result[2];
                double totalPrecioPedidos = (double) result[3];

                ClienteRankingDTO dto = new ClienteRankingDTO(nombre, apellido, cantidadPedidos, totalPrecioPedidos);
                rankingDTOs.add(dto);
            }
            return rankingDTOs;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
