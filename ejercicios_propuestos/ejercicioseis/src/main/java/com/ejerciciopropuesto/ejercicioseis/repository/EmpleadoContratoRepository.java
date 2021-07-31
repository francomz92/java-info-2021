package com.ejerciciopropuesto.ejercicioseis.repository;

import com.ejerciciopropuesto.ejercicioseis.entity.Empleado;
import com.ejerciciopropuesto.ejercicioseis.entity.EmpleadoContrato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpleadoContratoRepository extends CrudRepository<EmpleadoContrato, Long> {
}
