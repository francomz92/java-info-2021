package com.spring_rest_LevelUno.tienda.repository;

import com.spring_rest_LevelUno.tienda.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
