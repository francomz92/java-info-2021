package com.spring_rest_LevelUno.tienda.controller;

import com.spring_rest_LevelUno.tienda.entity.Usuario;
import com.spring_rest_LevelUno.tienda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping(value = "/usuarios")
    public Iterable<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }

    @GetMapping(value = "/usuarios/{id}")
    public Optional<Usuario> getUsuario(@PathVariable("id") Long id) {
        return usuarioRepository.findById(id);
    }

    @PostMapping(value = "/usuarios")
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @PutMapping(value = "/usuarios/{id}")
    public Usuario updateUsuario(@PathVariable("id") Long id, @RequestBody Usuario requestUsuario) {
        Usuario usuario = usuarioRepository.findById(id).get();
        usuario.setNombre(requestUsuario.getNombre());
        usuario.setApellido(requestUsuario.getApellido());
        usuario.setDireccion(requestUsuario.getDireccion());
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping(value = "/usuarios/{id}")
    public void deleteUsuario(@PathVariable("id") Long id) {
        usuarioRepository.deleteById(id);
    }
}
