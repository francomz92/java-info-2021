package com.ejerciciopropuesto.ejercicioseis.entity;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Entity
@Table(name = "EmpleadosJornada")
public class EmpleadoJornada extends Empleado {

    @Max(8)
    @NotEmpty
    @DecimalMax("2")
    private BigDecimal pagoHora;

    public EmpleadoJornada() {}

	public EmpleadoJornada(BigDecimal pagoHora) {
		this.pagoHora = pagoHora;
	}

    public BigDecimal getPagoHora() {
        return pagoHora;
    }

    public void setPagoHora(BigDecimal pagoHora) {
        this.pagoHora = pagoHora;
    }

    @Override
    public String toString() {
        return String.format("Empleado de Jornada: %s %s", this.getNombre(), this.getApellido());
    }

}
