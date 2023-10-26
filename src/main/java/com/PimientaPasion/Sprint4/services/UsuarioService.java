package com.PimientaPasion.Sprint4.services;

import com.PimientaPasion.Sprint4.entities.Usuario;

import java.util.List;

public interface UsuarioService extends BaseService<Usuario,Long>{

    List<Usuario> searchNativo(String filtro) throws Exception;

}

