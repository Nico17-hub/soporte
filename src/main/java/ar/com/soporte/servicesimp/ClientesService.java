package ar.com.soporte.servicesimp;

import ar.com.soporte.dao.IClientesDao;
import ar.com.soporte.entities.Clientes;
import ar.com.soporte.services.IClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientesService implements IClientesService {

    @Autowired
    private IClientesDao entityDao;

    @Override
    public List<Clientes> getAll() {
        return entityDao.findAll(
                Sort.by(Sort.Direction.ASC, "apellido")
        );
    }

    @Override
    public Page<Clientes> findAll(Pageable pageable) {
        return entityDao.findAll(
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        Sort.by(Sort.Direction.ASC, "apellido")
                )
        );
    }

    @Override
    public List<Clientes> findByApellido(String apellido) {
        return entityDao.findByApellido("%" + apellido + "%");
    }

    @Override
    public Clientes get(String id) {
        return entityDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(Clientes entity) {
        entityDao.save(entity);
    }

    @Override
    @Transactional
    public String delete(Clientes entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
