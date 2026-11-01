package ar.com.soporte.services;

import ar.com.soporte.entities.Reclamos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IReclamosService {

    List<Reclamos> getAll();

    Page<Reclamos> findAll(Pageable pageable);

    List<Reclamos> findByCliente(String clienteId);

    Reclamos get(String id);

    void save(Reclamos entity);

    String delete(Reclamos entity);
}
