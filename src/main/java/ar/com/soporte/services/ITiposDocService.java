package ar.com.soporte.services;

import ar.com.soporte.entities.TiposDoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITiposDocService {

    List<TiposDoc> getAll();

    Page<TiposDoc> findAll(Pageable pageable);

    List<TiposDoc> findByDescrip(String descrip);

    TiposDoc get(Integer id);

    void save(TiposDoc entity);

    String delete(TiposDoc entity);
}
