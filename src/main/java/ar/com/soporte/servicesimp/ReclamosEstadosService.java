package ar.com.soporte.servicesimp;

import ar.com.soporte.dao.IReclamosEstadosDao;
import ar.com.soporte.entities.ReclamosEstados;
import ar.com.soporte.services.IReclamosEstadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReclamosEstadosService implements IReclamosEstadosService {

    @Autowired
    private IReclamosEstadosDao entityDao;

    @Override
    public List<ReclamosEstados> getAll() {
        return entityDao.findAll(
                Sort.by(Sort.Direction.ASC, "prioridad")
        );
    }

    @Override
    public Page<ReclamosEstados> findAll(Pageable pageable) {
        return entityDao.findAll(
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        Sort.by(Sort.Direction.ASC, "prioridad")
                )
        );
    }

    @Override
    public List<ReclamosEstados> findByDescrip(String descrip) {
        return entityDao.findByDescrip("%" + descrip + "%");
    }

    @Override
    public ReclamosEstados get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(ReclamosEstados entity) {
        entityDao.save(entity);
    }

    @Override
    @Transactional
    public String delete(ReclamosEstados entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
