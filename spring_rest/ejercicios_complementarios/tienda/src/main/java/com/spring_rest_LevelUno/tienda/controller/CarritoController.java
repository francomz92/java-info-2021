package com.spring_rest_LevelUno.tienda.controller;

import com.spring_rest_LevelUno.tienda.entity.Carrito;
import com.spring_rest_LevelUno.tienda.entity.Usuario;
import com.spring_rest_LevelUno.tienda.repository.CarritoRepository;
import com.spring_rest_LevelUno.tienda.repository.DetalleRepository;
import com.spring_rest_LevelUno.tienda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
   public Iterable<Carrito> getCarritosByUsuario(@PathVariable("id") Long id) {
      Usuario usuario = usuarioRepository.getById(id);
      return usuario.getCarritos();
   }

   @GetMapping(value = "/usuarios/{idUsuario}/carritos/{idCarrito}")
   public Optional<Carrito> getCarritoById(@PathVariable("idUsuario") Long idUsuario, @PathVariable("idCarrito") Long idCarrito) {
      Usuario usuario = usuarioRepository.getById(idUsuario);
      return usuario.getCarritos().stream().filter(carrito -> carrito.getId().equals(idCarrito)).findFirst();
   }

   @PostMapping(value = "/usuarios/{id}/carritos")
   public Carrito createCarrito(@PathVariable("id") Long id, @Valid @RequestBody Carrito requestCarrito) {
      Usuario usuario = usuarioRepository.getById(id);
      requestCarrito.setUsuario(usuario);
      requestCarrito.getDetalles().forEach(detalle -> {
         detalle.setTotal();
         detalle.setCarrito(requestCarrito);
         detalleRepository.save(detalle);
      });
      usuario.addCarrito(requestCarrito);
      return carritoRepository.save(requestCarrito);
   }

   @PutMapping(value = "/usuarios/{idUsuario}/carritos/{idCarrito}")
   public Carrito updateCarrito(@PathVariable("idUsuario") Long idUsuario, @PathVariable("idCarrito") Long idCarrito, @Valid @RequestBody Carrito requestCarrito) {
      Usuario usuario = usuarioRepository.getById(idUsuario);
      Carrito carrito = carritoRepository.getById(idCarrito);
      requestCarrito.getDetalles().forEach(detalle -> {
         detalle.setCarrito(carrito);
         detalle.setTotal();
         if (detalle.getCantidad().equals(0)) {
            requestCarrito.getDetalles().remove(detalle);
         }
      });
      carrito.setDetalles(requestCarrito.getDetalles());
      return carritoRepository.saveAndFlush(carrito);
   }

   @DeleteMapping(value = "/usuarios/{idUsuario}/carritos/{idCarrito}")
   public void deleteCarrito(@PathVariable("idUsuario") Long idUsuario, @PathVariable("idCarrito") Long idCarrito) {
      Usuario usuario = usuarioRepository.getById(idUsuario);
      Carrito carrito = carritoRepository.getById(idCarrito);
      usuario.getCarritos().remove(carrito);
      carritoRepository.deleteById(idCarrito);
   }
}
