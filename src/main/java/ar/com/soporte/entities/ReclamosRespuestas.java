package ar.com.soporte.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "reclamos_respuestas")
public class ReclamosRespuestas {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahora;

    private int prioridad;

    @ManyToOne
    @JoinColumn(name = "reclamo_id", nullable = false)
    private Reclamos reclamo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechahora() {
        return fechahora;
    }

    public void setFechahora(Date fechahora) {
        this.fechahora = fechahora;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public Reclamos getReclamo() {
        return reclamo;
    }

    public void setReclamo(Reclamos reclamo) {
        this.reclamo = reclamo;
    }
}
