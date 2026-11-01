package ar.com.soporte.dao;

import ar.com.soporte.entities.ClienteServicioContrato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClienteServicioContratoDao
        extends JpaRepository<ClienteServicioContrato, String> {

    List<ClienteServicioContrato> findByCliente_Id(String clienteId);
}
