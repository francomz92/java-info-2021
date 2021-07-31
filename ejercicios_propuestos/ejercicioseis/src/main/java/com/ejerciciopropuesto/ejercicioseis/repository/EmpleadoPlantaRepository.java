package com.ejerciciopropuesto.ejercicioseis.repository;

import com.ejerciciopropuesto.ejercicioseis.entity.EmpleadoPlanta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoPlantaRepository extends CrudRepository<EmpleadoPlanta, Long> {
}
