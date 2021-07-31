package com.ejerciciopropuesto.ejercicioseis.entity;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

@Entity
@Table(name = "EmpleadosContrato")
public class EmpleadoContrato extends Empleado {

    private LocalDate fechaVencimiento;
    @Max(30)
    @NotEmpty
    private String especialidad;
    @Max(8)
    @NotEmpty
    @DecimalMax("2")
    private BigDecimal sueldo;

    public EmpleadoContrato(){}

	public EmpleadoContrato(String fechaVencimiento, String especialidad, BigDecimal sueldo) {
		this.fechaVencimiento = this.parseFechaVencimiento(fechaVencimiento);
		this.especialidad = especialidad;
		this.sueldo = sueldo;
	}

	private LocalDate parseFechaVencimiento(String fechaVencimiento) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate finalFecha = LocalDate.parse(fechaVencimiento, formato);
        return finalFecha.isAfter(LocalDate.now()) ? finalFecha : null;
    }

    public LocalDate getFechaVencimiento() {
        return this.fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
	    this.fechaVencimiento = this.parseFechaVencimiento(fechaVencimiento);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return String.format("Empleado de Contratado: %s %s", this.getNombre(), this.getApellido());
    }
}
