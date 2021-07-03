package com.ejerciciopropuesto.ejercicioseis.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "EmpleadosJornada")
@PrimaryKeyJoinColumn(name = "empleadosId")
public class EmpleadoJornada extends Empleado {

    @Column(length = 8)
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
