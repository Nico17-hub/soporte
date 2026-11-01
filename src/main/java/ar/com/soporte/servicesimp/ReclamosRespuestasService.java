package ar.com.soporte.servicesimp;

import ar.com.soporte.dao.IReclamosRespuestasDao;
import ar.com.soporte.entities.ReclamosRespuestas;
import ar.com.soporte.services.IReclamosRespuestasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReclamosRespuestasService
        implements IReclamosRespuestasService {

    @Autowired
    private IReclamosRespuestasDao entityDao;

    @Override
    public List<ReclamosRespuestas> findByReclamo(String reclamoId) {
        return entityDao.findByReclamo_IdOrderByPrioridadAsc(reclamoId);
    }

    @Override
    public ReclamosRespuestas get(String id) {
        return entityDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(ReclamosRespuestas entity) {
        entityDao.save(entity);
    }

    @Override
    @Transactional
    public String delete(ReclamosRespuestas entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
