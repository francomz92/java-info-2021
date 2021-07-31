package com.spring_rest_LevelUno.tienda.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaCompra;
    @OneToOne
    private Usuario usuario;
    @OneToMany
    private List<DetalleProducto> detalle;
    private String estado = "En curso";

    public Carrito(){}

    public void estadoCerrado() {
        this.estado = "Cerrado";
    }

    public Long getId() {
        return id;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<DetalleProducto> getDetalle() {
        return detalle;
    }

    public String getEstado() {
        return estado;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setDetalle(List<DetalleProducto> detalle) {
        this.detalle = detalle;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
