package ar.com.soporte.services;

import ar.com.soporte.entities.ReclamosRespuestas;

import java.util.List;

public interface IReclamosRespuestasService {

    List<ReclamosRespuestas> findByReclamo(String reclamoId);

    ReclamosRespuestas get(String id);

    void save(ReclamosRespuestas entity);

    String delete(ReclamosRespuestas entity);
}
