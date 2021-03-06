package com.spring_rest_LevelUno.tienda.entity;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String codigoInventario;
    private String nombre;
    private String descripcion;
    private BigDecimal precioUnitario;
    private String categoria;

    public Producto(){}

    public Producto(String codigoInventario, String nombre, String descripcion, BigDecimal precioUnitario, String categoria) {
        this.codigoInventario = codigoInventario;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.categoria = categoria;
    }


//  -----> Getters Method <-----

    public Long getId() {
        return id;
    }

    public String getCodigoInventario() {
        return codigoInventario;
    }

    public String getNombre() { return nombre; }

    public String getDescripcion() { return descripcion; }

    public BigDecimal getPrecioUnitario() { return precioUnitario; }

    public String getCategoria() { return categoria; }

    //  -----> Setters Methods <-----

    public void setId(Long id) { this.id = id; }

    public void setCodigoInventario(String codigoInventario) { this.codigoInventario = codigoInventario; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
