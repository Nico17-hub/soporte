package ar.com.soporte.servicesimp;

import ar.com.soporte.dao.IClienteServicioContratoDao;
import ar.com.soporte.entities.ClienteServicioContrato;
import ar.com.soporte.services.IClienteServicioContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServicioContratoService
        implements IClienteServicioContratoService {

    @Autowired
    private IClienteServicioContratoDao entityDao;

    @Override
    public List<ClienteServicioContrato> getAll() {
        return entityDao.findAll();
    }

    @Override
    public List<ClienteServicioContrato> findByCliente(String clienteId) {
        return entityDao.findByCliente_Id(clienteId);
    }

    @Override
    public ClienteServicioContrato get(String id) {
        return entityDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(ClienteServicioContrato entity) {
        entityDao.save(entity);
    }

    @Override
    @Transactional
    public String delete(ClienteServicioContrato entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
