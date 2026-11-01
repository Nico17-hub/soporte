package ar.com.soporte.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cliente_servicio_contrato")
public class ClienteServicioContrato {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Clientes cliente;

    @Temporal(TemporalType.DATE)
    private Date fechaalta;

    @Temporal(TemporalType.DATE)
    private Date fechabaja;

    @ManyToOne
    @JoinColumn(name = "servicio_id", nullable = false)
    private Servicios servicio;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Date getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(Date fechaalta) {
        this.fechaalta = fechaalta;
    }

    public Date getFechabaja() {
        return fechabaja;
    }

    public void setFechabaja(Date fechabaja) {
        this.fechabaja = fechabaja;
    }

    public Servicios getServicio() {
        return servicio;
    }

    public void setServicio(Servicios servicio) {
        this.servicio = servicio;
    }
}
