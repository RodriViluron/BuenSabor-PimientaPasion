package com.PimientaPasion.Sprint4.repositories;

import com.PimientaPasion.Sprint4.entities.Cliente;
import com.PimientaPasion.Sprint4.entities.Ingrediente;
import com.PimientaPasion.Sprint4.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long> {

    @Query(value = "SELECT c FROM Cliente c WHERE c.nombre LIKE %:filtro% OR c.apellido LIKE %:filtro%")
    List<Cliente> search(@Param("filtro") String filtro);

    @Query(value = "SELECT c FROM Cliente c WHERE c.nombre LIKE %:filtro% OR c.apellido LIKE %:filtro%")
    Page<Cliente> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM cliente WHERE cliente.nombre OR cliente.apellido LIKE %:filtro%",
            nativeQuery = true
    )
    List<Cliente> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM cliente WHERE cliente.nombre LIKE %:filtro% OR cliente.apellido LIKE %:filtro%",
            countQuery = "SELECT count (*) FROM cliente",
            nativeQuery = true
    )
  Page<Cliente> searchNativo(@Param("filtro") String filtro, Pageable pageable);

    //Query de inicio de sesion cliente
    @Query(
            value="select c from Cliente c where c.usuario.username = :filtro1 and c.usuario.contraseña = :filtro2")
    Cliente singInCliente (@Param("filtro1") String filtro1,@Param("filtro2") String filtro2);

}
