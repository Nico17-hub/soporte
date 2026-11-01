package ar.com.soporte.services;

import ar.com.soporte.entities.ClienteServicioContrato;

import java.util.List;

public interface IClienteServicioContratoService {

    List<ClienteServicioContrato> getAll();

    List<ClienteServicioContrato> findByCliente(String clienteId);

    ClienteServicioContrato get(String id);

    void save(ClienteServicioContrato entity);

    String delete(ClienteServicioContrato entity);
}
