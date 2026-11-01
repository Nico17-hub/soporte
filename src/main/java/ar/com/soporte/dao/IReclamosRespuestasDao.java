package ar.com.soporte.dao;

import ar.com.soporte.entities.ReclamosRespuestas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IReclamosRespuestasDao
        extends JpaRepository<ReclamosRespuestas, String> {

    List<ReclamosRespuestas> findByReclamo_IdOrderByPrioridadAsc(String reclamoId);
}
