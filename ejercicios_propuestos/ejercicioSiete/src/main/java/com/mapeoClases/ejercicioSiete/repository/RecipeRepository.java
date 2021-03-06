package com.mapeoClases.ejercicioSiete.repository;

import com.mapeoClases.ejercicioSiete.entity.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    Iterable<Recipe> findByDescripcion(String descripcion);
}
