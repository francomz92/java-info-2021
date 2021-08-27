package com.spring_rest_LevelUno.tienda.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Debe proporcionar un nombre")
    @NotBlank(message = "Debe proporcionar un nombre")
    private String nombre;

    @NotNull(message = "Debe proporcionar un apellido")
    @NotBlank(message = "Debe proporcionar un apellido")
    private String apellido;

    private String direccion;

    @CreationTimestamp
    private Instant fechaAlta;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Carrito.class, orphanRemoval = true)
    private List<Carrito> carritos = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Orden.class, orphanRemoval = true)
    private List<Orden> compras = new ArrayList<>();

    public Usuario(){}

    public Usuario(String nombre, String apellido, String direccion){
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }


    //  -----> Getters Method <-----

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() { return apellido; }

    public String getDireccion() {
        return direccion;
    }

    public Instant getFechaAlta() {return fechaAlta;}

    public List<Carrito> getCarritos() { return carritos; }

    public List<Orden> getCompras() { return compras; }

    //  -----> Setters Methods <-----

    public void setId(Long id) { this.id = id; }

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

    public void setCarritos(List<Carrito> carritos) {
        this.carritos = carritos;
    }

    public void addCarrito(Carrito carrito) { this.carritos.add(carrito); }

    public void setCompras(List<Orden> compras) { this.compras = compras; }

    public void addCompra(Orden compra) { this.compras.add(compra); }
}
