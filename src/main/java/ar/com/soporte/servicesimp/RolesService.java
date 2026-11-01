package ar.com.soporte.servicesimp;

import ar.com.soporte.dao.IRolesDao;
import ar.com.soporte.entities.Roles;
import ar.com.soporte.services.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RolesService implements IRolesService {

    @Autowired
    private IRolesDao entityDao;

    @Override
    public List<Roles> getAll() {
        return entityDao.findAll(Sort.by(Sort.Direction.ASC, "descrip"));
    }

    @Override
    public Page<Roles> findAll(Pageable pageable) {
        return entityDao.findAll(
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        Sort.by(Sort.Direction.ASC, "descrip")
                )
        );
    }

    @Override
    public List<Roles> findByDescrip(String descrip) {
        return entityDao.findByDescrip("%" + descrip + "%");
    }

    @Override
    public Roles get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(Roles entity) {
        entityDao.save(entity);
    }

    @Override
    @Transactional
    public String delete(Roles entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
