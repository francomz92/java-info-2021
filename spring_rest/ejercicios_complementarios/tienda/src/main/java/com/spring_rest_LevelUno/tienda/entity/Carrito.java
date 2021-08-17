package com.spring_rest_LevelUno.tienda.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carrito")
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private Instant fechaCreacion;

//    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_usuario")
    private Usuario usuario;

    @Transient
    private String comprador;

//    @JsonManagedReference
    @OneToMany(mappedBy = "carrito", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Detalle> detalles = new ArrayList<>();

    private String estado;

    public Carrito(){}

    public Carrito(Usuario usuario, List<Detalle> detalles) {
        this.estado = "En curso";
        this.usuario = usuario;
        this.detalles = detalles;
    }


    //    -----> Getters Method <-----

    public Long getId() {
        return id;
    }

    public Instant getFechaCreacion() {
        return fechaCreacion;
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    public String getEstado() {
        return estado;
    }

    public String getComprador() {
        return this.usuario.getNombre().concat(" ").concat(this.usuario.getApellido());
    }

    // -----> Setters Methods <-----

    public void setFechaCreacion(Instant fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void addDetalles(Detalle detalle) {
        this.detalles.add(detalle);
    }
}
