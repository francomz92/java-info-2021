package com.spring_rest_LevelUno.tienda.repository;

import com.spring_rest_LevelUno.tienda.entity.Carrito;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepository extends CrudRepository<Carrito, Long> {
}
