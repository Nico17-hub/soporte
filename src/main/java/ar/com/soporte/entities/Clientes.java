package ar.com.soporte.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String apellido;

    private String direccion;

    private String email;

    private String nombre;

    private String nrodoc;

    private String telefono;

    @ManyToOne
    @JoinColumn(name = "tipodoc_id")
    private TiposDoc tipodoc;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNrodoc() {
        return nrodoc;
    }

    public void setNrodoc(String nrodoc) {
        this.nrodoc = nrodoc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TiposDoc getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(TiposDoc tipodoc) {
        this.tipodoc = tipodoc;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
