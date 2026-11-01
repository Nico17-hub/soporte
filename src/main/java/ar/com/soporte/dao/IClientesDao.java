package ar.com.soporte.dao;

import ar.com.soporte.entities.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IClientesDao extends JpaRepository<Clientes, String> {

    @Query("select c from Clientes c where c.apellido like ?1")
    List<Clientes> findByApellido(String apellido);
}
