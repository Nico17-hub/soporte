package ar.com.soporte.dao;

import ar.com.soporte.entities.MotivosReclamos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMotivosReclamosDao extends JpaRepository<MotivosReclamos, Integer> {

    @Query("select m from MotivosReclamos m where m.descrip like ?1")
    List<MotivosReclamos> findByDescrip(String descrip);
}
