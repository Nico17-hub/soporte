package ar.com.soporte.servicesimp;

import ar.com.soporte.dao.IMotivosReclamosDao;
import ar.com.soporte.entities.MotivosReclamos;
import ar.com.soporte.services.IMotivosReclamosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MotivosReclamosService implements IMotivosReclamosService {

    @Autowired
    private IMotivosReclamosDao entityDao;

    @Override
    public List<MotivosReclamos> getAll() {
        return entityDao.findAll(
                Sort.by(Sort.Direction.ASC, "descrip")
        );
    }

    @Override
    public Page<MotivosReclamos> findAll(Pageable pageable) {
        return entityDao.findAll(
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        Sort.by(Sort.Direction.ASC, "descrip")
                )
        );
    }

    @Override
    public List<MotivosReclamos> findByDescrip(String descrip) {
        return entityDao.findByDescrip("%" + descrip + "%");
    }

    @Override
    public MotivosReclamos get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(MotivosReclamos entity) {
        entityDao.save(entity);
    }

    @Override
    @Transactional
    public String delete(MotivosReclamos entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
