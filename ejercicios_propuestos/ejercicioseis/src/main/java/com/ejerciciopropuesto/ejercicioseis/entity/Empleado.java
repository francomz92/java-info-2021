package com.ejerciciopropuesto.ejercicioseis.entity;

import javax.persistence.*;

@Entity
@Table(name = "Empleados")
@Inheritance(strategy = InheritanceType.JOINED)
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 25)
    private String nombre;
    @Column(length = 25)
    private String apellido;

    public Empleado() {}

    public Empleado(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {return apellido;}

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return String.format("Usuario %d %s %s", this.id, this.nombre, this.apellido);
    }
}
