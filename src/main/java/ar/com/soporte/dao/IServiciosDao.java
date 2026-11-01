package ar.com.soporte.dao;

import ar.com.soporte.entities.Servicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IServiciosDao extends JpaRepository<Servicios, Integer> {

    @Query("select s from Servicios s where s.descrip like ?1")
    List<Servicios> findByDescrip(String descrip);
}
