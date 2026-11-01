package ar.com.soporte.servicesimp;

import ar.com.soporte.dao.IReclamosDao;
import ar.com.soporte.entities.Reclamos;
import ar.com.soporte.services.IReclamosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReclamosService implements IReclamosService {

    @Autowired
    private IReclamosDao entityDao;

    @Override
    public List<Reclamos> getAll() {
        return entityDao.findAll(
                Sort.by(Sort.Direction.DESC, "fechahora")
        );
    }

    @Override
    public Page<Reclamos> findAll(Pageable pageable) {
        return entityDao.findAll(
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        Sort.by(Sort.Direction.DESC, "fechahora")
                )
        );
    }

    @Override
    public List<Reclamos> findByCliente(String clienteId) {
        return entityDao.findByCliente_Id(clienteId);
    }

    @Override
    public Reclamos get(String id) {
        return entityDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(Reclamos entity) {
        entityDao.save(entity);
    }

    @Override
    @Transactional
    public String delete(Reclamos entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
