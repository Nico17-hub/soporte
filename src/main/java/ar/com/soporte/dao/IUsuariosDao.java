package ar.com.soporte.dao;

import ar.com.soporte.entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUsuariosDao extends JpaRepository<Usuarios, Integer> {

    @Query("select u from Usuarios u where u.username like ?1")
    List<Usuarios> findByUsername(String username);

    Usuarios findOneByUsername(String username);
}
