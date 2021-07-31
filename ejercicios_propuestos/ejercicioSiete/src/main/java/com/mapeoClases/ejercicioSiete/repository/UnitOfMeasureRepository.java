package com.mapeoClases.ejercicioSiete.repository;

import com.mapeoClases.ejercicioSiete.entity.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
