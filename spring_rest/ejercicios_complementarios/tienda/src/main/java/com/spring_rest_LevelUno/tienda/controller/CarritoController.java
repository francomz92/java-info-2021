package com.spring_rest_LevelUno.tienda.controller;

import com.spring_rest_LevelUno.tienda.entity.Carrito;
import com.spring_rest_LevelUno.tienda.entity.Usuario;
import com.spring_rest_LevelUno.tienda.exceptions.ResourceNotFound;
import com.spring_rest_LevelUno.tienda.repository.CarritoRepository;
import com.spring_rest_LevelUno.tienda.repository.DetalleRepository;
import com.spring_rest_LevelUno.tienda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
public class CarritoController {
   @Autowired
   CarritoRepository carritoRepository;
   @Autowired
   UsuarioRepository usuarioRepository;
   @Autowired
   DetalleRepository detalleRepository;

   @GetMapping(value = "/usuarios/{id}/carritos")
   public ResponseEntity<?> getCarritosByUsuario(@PathVariable("id") Long id) {
      Optional<Usuario> usuario = usuarioRepository.findById(id);
      if (usuario.isEmpty()) {
         throw new ResourceNotFound("¡No se encontraron carritos!");
      }
      return ResponseEntity.status(HttpStatus.OK).body(usuario.get().getCarritos());
   }

   @GetMapping(value = "/usuarios/{idUsuario}/carritos/{idCarrito}")
   public ResponseEntity<?> getCarritoById(@PathVariable("idUsuario") Long idUsuario, @PathVariable("idCarrito") Long idCarrito) {
      Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
      Optional<Carrito> carrito = carritoRepository.findById(idCarrito);
      if (usuario.isEmpty() || carrito.isEmpty() || !usuario.get().getCarritos().contains(carrito.get())) {
         throw new ResourceNotFound("¡No existe el carrito solicitado!");
      }
      return ResponseEntity.status(HttpStatus.OK).body(carrito);
   }

   @PostMapping(value = "/usuarios/{id}/carritos")
   public ResponseEntity<?> createCarrito(@PathVariable("id") Long id, @Valid @RequestBody Carrito requestCarrito) {
      Optional<Usuario> usuario = usuarioRepository.findById(id);
      if (usuario.isEmpty()) {
         throw new ResourceNotFound("¡No se pueden agregar carritos a un usuario inexistente!");
      }
      requestCarrito.setUsuario(usuario.get());
      requestCarrito.getDetalles().forEach(detalle -> {
         detalle.setTotal();
         detalle.setCarrito(requestCarrito);
         detalleRepository.save(detalle);
      });
      usuario.get().addCarrito(requestCarrito);
      return ResponseEntity.status(HttpStatus.CREATED).body(carritoRepository.save(requestCarrito));
   }

   @PutMapping(value = "/usuarios/{idUsuario}/carritos/{idCarrito}")
   public ResponseEntity<?> updateCarrito(@PathVariable("idUsuario") Long idUsuario, @PathVariable("idCarrito") Long idCarrito, @Valid @RequestBody Carrito requestCarrito) {
      Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
      Optional<Carrito> carrito = carritoRepository.findById(idCarrito);
      if (usuario.isEmpty() || carrito.isEmpty() || !usuario.get().getCarritos().contains(carrito.get())) {
         throw new ResourceNotFound("¡No se encontró el carrito solicitado!");
      }
      requestCarrito.getDetalles().forEach(detalle -> {
         detalle.setCarrito(carrito.get());
         detalle.setTotal();
         if (detalle.getCantidad().equals(0)) {
            requestCarrito.getDetalles().remove(detalle);
         }
      });
      carrito.get().setDetalles(requestCarrito.getDetalles());
      return ResponseEntity.status(HttpStatus.OK).body(carritoRepository.saveAndFlush(carrito.get()));
   }

   @DeleteMapping(value = "/usuarios/{idUsuario}/carritos/{idCarrito}")
   public ResponseEntity<?> deleteCarrito(@PathVariable("idUsuario") Long idUsuario, @PathVariable("idCarrito") Long idCarrito) {
      Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
      Optional<Carrito> carrito = carritoRepository.findById(idCarrito);
      if (usuario.isEmpty() || carrito.isEmpty() || !usuario.get().getCarritos().contains(carrito.get())) {
         throw new ResourceNotFound("¡El carrito que desea eliminar no existe!");
      }
      usuario.get().getCarritos().remove(carrito.get());
      carritoRepository.deleteById(idCarrito);
      return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
   }
}
