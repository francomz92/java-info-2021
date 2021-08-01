package com.spring_rest_LevelUno.tienda.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDate fechaCreacion;
    @NotNull
    @ManyToOne
    private Usuario id_usuario;
    @ManyToMany
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

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public List<Detalle> getDetalleCarrito() {
        return detalleCarrito;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setDetalleCarrito(List<Detalle> detalleCarrito) {
        this.detalleCarrito = detalleCarrito;
    }
}
