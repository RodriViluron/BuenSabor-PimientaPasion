package com.PimientaPasion.BuenSabor.services;

import com.PimientaPasion.BuenSabor.entities.Producto;
import com.PimientaPasion.BuenSabor.repositories.BaseRepository;
import com.PimientaPasion.BuenSabor.repositories.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl extends BaseServiceImpl<Producto, Long> implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public ProductoServiceImpl(BaseRepository<Producto, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    @Transactional
    public List<Producto> buscarPorDenominacion(String denominacion) throws Exception {
        try {
            List<Producto> productos = productoRepository.buscarPorDenominacion(denominacion);
            return productos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Page<Producto> buscarPorDenominacion(String denominacion, Pageable pageable) throws Exception {
        try {
            Page<Producto> productos = productoRepository.buscarPorDenominacion(denominacion, pageable);
            return productos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<Producto> buscarDisponibles() throws Exception {
        try{
            List<Producto> productos=productoRepository.buscarDisponibles();
            return productos;
        }
        catch (Exception e){
            throw new Exception (e.getMessage());
        }
    }

}
