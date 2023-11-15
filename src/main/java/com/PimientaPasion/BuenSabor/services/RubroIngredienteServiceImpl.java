package com.PimientaPasion.BuenSabor.services;

import com.PimientaPasion.BuenSabor.entities.RubroIngrediente;
import com.PimientaPasion.BuenSabor.repositories.BaseRepository;
import com.PimientaPasion.BuenSabor.repositories.RubroProductoRepository;
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
