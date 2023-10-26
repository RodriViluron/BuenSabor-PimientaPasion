package com.PimientaPasion.Sprint4.services;

import com.PimientaPasion.Sprint4.entities.Usuario;
import com.PimientaPasion.Sprint4.repositories.BaseRepository;
import com.PimientaPasion.Sprint4.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(BaseRepository<Usuario, Long> baseRepository, UsuarioRepository usuarioRepository) {
        super(baseRepository);
        this.usuarioRepository = usuarioRepository;
    }
    @Override
    public List<Usuario> searchNativo(String filtro) throws Exception {
        try{

            List<Usuario> usuario = usuarioRepository.searchNativo(filtro);
            return usuario;

        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public List<Usuario> findAll() throws Exception {
        return null;
    }

    @Override
    public Page<Usuario> findAll(Pageable pageable) throws Exception {
        return null;
    }

    @Override
    public Usuario findById(Long aLong) throws Exception {
        return null;
    }

    @Override
    public Usuario save(Usuario entity) throws Exception {
        return null;
    }

    @Override
    public Usuario update(Long aLong, Usuario entity) throws Exception {
        return null;
    }

    @Override
    public boolean delete(Long aLong) throws Exception {
        return false;
    }

}
