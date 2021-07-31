package com.mapeoClases.ejercicioSiete.repository;

import com.mapeoClases.ejercicioSiete.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
