package com.spring_rest_LevelUno.tienda.service;

import com.spring_rest_LevelUno.tienda.entity.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

   public void prepareUsuarioCreation(Usuario usuario, Usuario requestUsuario) {
      usuario.setNombre(requestUsuario.getNombre());
      usuario.setApellido(requestUsuario.getApellido());
      usuario.setDireccion(requestUsuario.getDireccion());
   }
}
