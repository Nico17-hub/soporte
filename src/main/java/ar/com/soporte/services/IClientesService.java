package ar.com.soporte.services;

import ar.com.soporte.entities.Clientes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClientesService {

    List<Clientes> getAll();

    Page<Clientes> findAll(Pageable pageable);

    List<Clientes> findByApellido(String apellido);

    Clientes get(String id);

    void save(Clientes entity);

    String delete(Clientes entity);
}
