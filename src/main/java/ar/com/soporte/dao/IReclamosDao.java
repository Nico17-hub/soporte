package ar.com.soporte.dao;

import ar.com.soporte.entities.Reclamos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IReclamosDao extends JpaRepository<Reclamos, String> {

    List<Reclamos> findByCliente_Id(String clienteId);
}
