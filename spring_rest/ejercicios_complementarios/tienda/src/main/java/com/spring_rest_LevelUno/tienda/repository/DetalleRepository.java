package com.spring_rest_LevelUno.tienda.repository;

import com.spring_rest_LevelUno.tienda.entity.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleRepository extends JpaRepository<Detalle, Long> {
}
