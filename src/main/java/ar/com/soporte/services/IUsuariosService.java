package ar.com.soporte.services;

import ar.com.soporte.entities.Usuarios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUsuariosService {

    List<Usuarios> getAll();

    Page<Usuarios> findAll(Pageable pageable);

    List<Usuarios> findByUsername(String username);

    Usuarios get(Integer id);

    void save(Usuarios entity);

    String delete(Usuarios entity);
}
