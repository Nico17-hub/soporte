package ar.com.soporte.dao;

import ar.com.soporte.entities.TiposDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITiposDocDao extends JpaRepository<TiposDoc, Integer> {

    @Query("select t from TiposDoc t where t.descrip like ?1")
    List<TiposDoc> findByDescrip(String descrip);
}
