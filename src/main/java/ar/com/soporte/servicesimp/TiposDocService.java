package ar.com.soporte.servicesimp;

import ar.com.soporte.dao.ITiposDocDao;
import ar.com.soporte.entities.TiposDoc;
import ar.com.soporte.services.ITiposDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TiposDocService implements ITiposDocService {

    @Autowired
    private ITiposDocDao entityDao;

    @Override
    public List<TiposDoc> getAll() {
        return entityDao.findAll(
                Sort.by(Sort.Direction.ASC, "descrip")
        );
    }

    @Override
    public Page<TiposDoc> findAll(Pageable pageable) {
        return entityDao.findAll(
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        Sort.by(Sort.Direction.ASC, "descrip")
                )
        );
    }

    @Override
    public List<TiposDoc> findByDescrip(String descrip) {
        return entityDao.findByDescrip("%" + descrip + "%");
    }

    @Override
    public TiposDoc get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(TiposDoc entity) {
        entityDao.save(entity);
    }

    @Override
    @Transactional
    public String delete(TiposDoc entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
