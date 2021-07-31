package com.spring_rest_LevelUno.tienda.repository;

import com.spring_rest_LevelUno.tienda.entity.DetalleProducto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleProductoRepository extends CrudRepository<DetalleProducto, Long> {
}
