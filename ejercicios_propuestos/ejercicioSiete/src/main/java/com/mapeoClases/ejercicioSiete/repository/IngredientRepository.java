package com.mapeoClases.ejercicioSiete.repository;

import com.mapeoClases.ejercicioSiete.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
