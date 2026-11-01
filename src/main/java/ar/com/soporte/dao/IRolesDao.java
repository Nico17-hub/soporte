package ar.com.soporte.dao;

import ar.com.soporte.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRolesDao extends JpaRepository<Roles, Integer> {

    @Query("select r from Roles r where r.descrip like ?1")
    List<Roles> findByDescrip(String descrip);
}
