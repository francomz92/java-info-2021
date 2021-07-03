package com.ejerciciopropuesto.ejercicioseis.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "EmpleadosPlanta")
@PrimaryKeyJoinColumn(name = "empleadosId")
public class EmpleadoPlanta extends Empleado {

    private LocalDate fechaInicio;
    @Column(length = 25)
    private String puesto;
    @Column(length = 8)
    private BigDecimal sueldo;

    public EmpleadoPlanta() {}

    public EmpleadoPlanta(String fechaInicio, String puesto, BigDecimal sueldo) {
        this.fechaInicio = this.parseFecha(fechaInicio);
        this.puesto = puesto;
        this.sueldo = sueldo;
    }

    private LocalDate parseFecha(String fecha) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate finalFecha = LocalDate.parse(fecha, formato);
        return finalFecha.isAfter(LocalDate.now()) ? finalFecha : null;
    }

    public LocalDate getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = this.parseFecha(fechaInicio);
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return String.format("Empleado de Planta: %s %s", this.getNombre(), this.getApellido());
    }
}
