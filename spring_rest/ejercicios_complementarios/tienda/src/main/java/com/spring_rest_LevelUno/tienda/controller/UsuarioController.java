package com.spring_rest_LevelUno.tienda.controller;

import com.spring_rest_LevelUno.tienda.entity.Usuario;
import com.spring_rest_LevelUno.tienda.exceptions.ResourceNotFound;
import com.spring_rest_LevelUno.tienda.repository.UsuarioRepository;
import com.spring_rest_LevelUno.tienda.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping(value = "/usuarios")
    public ResponseEntity<?> getUsuarios(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findAll());
    }

    @GetMapping(value = "/usuarios/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable("id") Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            throw new ResourceNotFound("¡No existe el usuario solicitado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @PostMapping(value = "/usuarios")
    public ResponseEntity<?> createUsuario(@Valid @RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
    }

    @PutMapping(value = "/usuarios/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable("id") Long id, @Valid @RequestBody Usuario requestUsuario) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            throw new ResourceNotFound("¡No existe el usuario solicitado!");
        }
        usuarioService.prepareUsuarioCreation(usuario.get(), requestUsuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuario.get()));
    }

    @DeleteMapping(value = "/usuarios/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable("id") Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            throw new ResourceNotFound("¡No existe el usuario solicitado!");
        }
        usuarioRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
    }
}
