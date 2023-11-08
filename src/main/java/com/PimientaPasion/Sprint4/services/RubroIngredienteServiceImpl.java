package com.PimientaPasion.Sprint4.services;

import com.PimientaPasion.Sprint4.entities.RubroIngrediente;
import com.PimientaPasion.Sprint4.entities.RubroProducto;
import com.PimientaPasion.Sprint4.repositories.BaseRepository;
import com.PimientaPasion.Sprint4.repositories.RubroProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubroIngredienteServiceImpl extends BaseServiceImpl<RubroIngrediente,Long>  implements RubroIngredienteService {

    @Autowired
    private RubroProductoRepository rubroProductoRepository;

    public RubroIngredienteServiceImpl(BaseRepository<RubroIngrediente, Long> baseRepository, RubroProductoRepository rubroProductoRepository) {
        super(baseRepository);
        this.rubroProductoRepository = rubroProductoRepository;
    }
}
