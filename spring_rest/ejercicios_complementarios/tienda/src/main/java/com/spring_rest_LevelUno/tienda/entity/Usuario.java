package com.spring_rest_LevelUno.tienda.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;


@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String direccion;
    @CreationTimestamp
    private Instant fechaAlta;
    @OneToMany
    private List<Carrito> id_carrito;

    public Usuario(String nombre, String apellido, String direccion, List<Carrito> carritos){
        this.id_carrito = carritos;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }
    public Usuario(){}

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {return apellido;}

    public String getDireccion() {
        return direccion;
    }

    public Instant getFechaAlta() {
        return fechaAlta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFechaAlta(Instant fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}
