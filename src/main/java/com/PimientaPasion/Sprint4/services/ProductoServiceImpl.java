package com.PimientaPasion.Sprint4.services;

import com.PimientaPasion.Sprint4.entities.Producto;
import com.PimientaPasion.Sprint4.repositories.BaseRepository;
import com.PimientaPasion.Sprint4.repositories.ProductoRepository;
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
    public List<Producto> buscarPorDenominacion(String denominacion) throws Exception {
        try {
            List<Producto> productos = productoRepository.buscarPorDenominacion(denominacion);
            return productos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Producto> buscarPorDenominacion(String denominacion, Pageable pageable) throws Exception {
        try {
            Page<Producto> productos = productoRepository.buscarPorDenominacion(denominacion, pageable);
            return productos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
