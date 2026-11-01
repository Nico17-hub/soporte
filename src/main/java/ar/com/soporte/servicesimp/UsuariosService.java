package ar.com.soporte.servicesimp;

import ar.com.soporte.dao.IUsuariosDao;
import ar.com.soporte.entities.Usuarios;
import ar.com.soporte.services.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuariosService implements IUsuariosService {

    @Autowired
    private IUsuariosDao entityDao;

    @Override
    public List<Usuarios> getAll() {
        return entityDao.findAll(
                Sort.by(Sort.Direction.ASC, "username")
        );
    }

    @Override
    public Page<Usuarios> findAll(Pageable pageable) {
        return entityDao.findAll(
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        Sort.by(Sort.Direction.ASC, "username")
                )
        );
    }

    @Override
    public List<Usuarios> findByUsername(String username) {
        return entityDao.findByUsername("%" + username + "%");
    }

    @Override
    public Usuarios get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(Usuarios entity) {
        entityDao.save(entity);
    }

    @Override
    @Transactional
    public String delete(Usuarios entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
