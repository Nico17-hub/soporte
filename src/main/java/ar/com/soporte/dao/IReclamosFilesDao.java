package ar.com.soporte.dao;

import ar.com.soporte.entities.ReclamosFiles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IReclamosFilesDao
        extends JpaRepository<ReclamosFiles, String> {

    List<ReclamosFiles> findByReclamo_Id(String reclamoId);
}
