package ar.com.soporte.dao;

import ar.com.soporte.entities.ReclamosEstados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IReclamosEstadosDao extends JpaRepository<ReclamosEstados, Integer> {

    @Query("select r from ReclamosEstados r where r.descrip like ?1")
    List<ReclamosEstados> findByDescrip(String descrip);
}
