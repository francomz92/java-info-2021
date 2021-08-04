package com.spring_rest_LevelUno.tienda.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
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

    @OneToMany(mappedBy = "id_usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Carrito.class, orphanRemoval = true)
    @JsonManagedReference
    private List<Carrito> id_carrito = new ArrayList<>();

    public Usuario(String nombre, String apellido, String direccion){
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

    public List<Carrito> getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(List<Carrito> id_carrito) {
        this.id_carrito = id_carrito;
    }
    public void addCarrito(Carrito carrito) {
        this.id_carrito.add(carrito);
    }
}
