package com.PimientaPasion.Sprint4.services;

import com.PimientaPasion.Sprint4.entities.RubroProducto;
import com.PimientaPasion.Sprint4.repositories.BaseRepository;
import com.PimientaPasion.Sprint4.repositories.RubroProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RubroProductoServiceImpl extends BaseServiceImpl<RubroProducto,Long>  implements RubroProductoService {

    @Autowired
    private RubroProductoRepository rubroProductoRepository;

    public RubroProductoServiceImpl(BaseRepository<RubroProducto, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<RubroProducto> buscarRubrosProdDisponibles() throws Exception {
        try {
            List<RubroProducto> rubroProductos=rubroProductoRepository.buscarRubrosProdDisponibles();
            return rubroProductos;
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
