package ar.com.soporte.services;

import ar.com.soporte.entities.Servicios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiciosService {

    List<Servicios> getAll();

    Page<Servicios> findAll(Pageable pageable);

    List<Servicios> findByDescrip(String descrip);

    Servicios get(Integer id);

    void save(Servicios entity);

    String delete(Servicios entity);
}
