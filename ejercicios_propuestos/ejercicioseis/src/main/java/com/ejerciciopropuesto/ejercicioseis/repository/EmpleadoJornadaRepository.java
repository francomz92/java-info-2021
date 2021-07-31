package com.ejerciciopropuesto.ejercicioseis.repository;

import com.ejerciciopropuesto.ejercicioseis.entity.EmpleadoJornada;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoJornadaRepository extends CrudRepository<EmpleadoJornada, Long> {
}
