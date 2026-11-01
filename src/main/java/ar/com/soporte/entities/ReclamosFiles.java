package ar.com.soporte.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "reclamos_files")
public class ReclamosFiles {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String file;

    @ManyToOne
    @JoinColumn(name = "reclamo_id", nullable = false)
    private Reclamos reclamo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Reclamos getReclamo() {
        return reclamo;
    }

    public void setReclamo(Reclamos reclamo) {
        this.reclamo = reclamo;
    }
}
