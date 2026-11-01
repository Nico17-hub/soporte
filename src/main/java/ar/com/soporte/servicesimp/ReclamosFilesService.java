package ar.com.soporte.servicesimp;

import ar.com.soporte.dao.IReclamosFilesDao;
import ar.com.soporte.entities.ReclamosFiles;
import ar.com.soporte.services.IReclamosFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReclamosFilesService
        implements IReclamosFilesService {

    @Autowired
    private IReclamosFilesDao entityDao;

    @Override
    public List<ReclamosFiles> findByReclamo(String reclamoId) {
        return entityDao.findByReclamo_Id(reclamoId);
    }

    @Override
    public ReclamosFiles get(String id) {
        return entityDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(ReclamosFiles entity) {
        entityDao.save(entity);
    }

    @Override
    @Transactional
    public String delete(ReclamosFiles entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
