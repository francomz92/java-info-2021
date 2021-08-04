package com.spring_rest_LevelUno.tienda.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private Instant fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_usuario")
    @JsonBackReference
    private Usuario id_usuario;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Detalle.class)
    @JoinColumn(name = "id_detalle", referencedColumnName = "id")
    private List<Detalle> detalleCarrito;
    private String estado;

    public Carrito(Usuario id_usuario, List<Detalle> detalleCarrito) {
        this.estado = "En curso";
        this.id_usuario = id_usuario;
        this.detalleCarrito = detalleCarrito;
    }

    public Carrito(){}

    public Long getId() {
        return id;
    }

    public Instant getFechaCreacion() {
        return fechaCreacion;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public List<Detalle> getDetalleCarrito() {
        return detalleCarrito;
    }

    public void setFechaCreacion(Instant fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setDetalleCarrito(List<Detalle> detalleCarrito) {
        this.detalleCarrito = detalleCarrito;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
