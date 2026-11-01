package ar.com.soporte.servicesimp;

import ar.com.soporte.dao.IServiciosDao;
import ar.com.soporte.entities.Servicios;
import ar.com.soporte.services.IServiciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiciosService implements IServiciosService {

    @Autowired
    private IServiciosDao entityDao;

    @Override
    public List<Servicios> getAll() {
        return entityDao.findAll(
                Sort.by(Sort.Direction.ASC, "descrip")
        );
    }

    @Override
    public Page<Servicios> findAll(Pageable pageable) {
        return entityDao.findAll(
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        Sort.by(Sort.Direction.ASC, "descrip")
                )
        );
    }

    @Override
    public List<Servicios> findByDescrip(String descrip) {
        return entityDao.findByDescrip("%" + descrip + "%");
    }

    @Override
    public Servicios get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(Servicios entity) {
        entityDao.save(entity);
    }

    @Override
    @Transactional
    public String delete(Servicios entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
