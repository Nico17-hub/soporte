package ar.com.soporte.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reclamos")
public class Reclamos {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String asunto;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "cliente_servicio_id")
    private ClienteServicioContrato clienteservicio;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private ReclamosEstados estado;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahora;

    private boolean finalizado;

    @Column(columnDefinition = "TEXT")
    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "motivo_id")
    private MotivosReclamos motivo;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    @OneToMany(mappedBy = "reclamo")
    private List<ReclamosFiles> files = new ArrayList<>();

    @OneToMany(mappedBy = "reclamo")
    private List<ReclamosRespuestas> respuesta = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public ClienteServicioContrato getClienteservicio() {
        return clienteservicio;
    }

    public void setClienteservicio(ClienteServicioContrato clienteservicio) {
        this.clienteservicio = clienteservicio;
    }

    public ReclamosEstados getEstado() {
        return estado;
    }

    public void setEstado(ReclamosEstados estado) {
        this.estado = estado;
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

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public MotivosReclamos getMotivo() {
        return motivo;
    }

    public void setMotivo(MotivosReclamos motivo) {
        this.motivo = motivo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<ReclamosFiles> getFiles() {
        return files;
    }

    public void setFiles(List<ReclamosFiles> files) {
        this.files = files;
    }

    public List<ReclamosRespuestas> getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(List<ReclamosRespuestas> respuesta) {
        this.respuesta = respuesta;
    }
}
