package ar.com.soporte.services;

import ar.com.soporte.entities.ReclamosFiles;

import java.util.List;

public interface IReclamosFilesService {

    List<ReclamosFiles> findByReclamo(String reclamoId);

    ReclamosFiles get(String id);

    void save(ReclamosFiles entity);

    String delete(ReclamosFiles entity);
}
