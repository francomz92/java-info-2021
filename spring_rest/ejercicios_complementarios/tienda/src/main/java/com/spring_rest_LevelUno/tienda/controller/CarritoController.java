package com.spring_rest_LevelUno.tienda.controller;

import com.spring_rest_LevelUno.tienda.entity.Carrito;
import com.spring_rest_LevelUno.tienda.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class CarritoController {
   @Autowired
   CarritoRepository carritoRepository;

   @GetMapping(value = "/carritos")
   public Iterable<Carrito> getCarritos() {
      return carritoRepository.findAll();
   }

   @GetMapping(value = "/carritos/{id}")
   public Optional<Carrito> getCarrito(@PathVariable("id") Long id) {
      return carritoRepository.findById(id);
   }

   @PostMapping(value = "/carritos")
   public  Carrito createCarrito(@Valid @RequestBody Carrito requestCarrito) {
      return carritoRepository.save(requestCarrito);
   }

   @PutMapping(value = "/carritos/{id}")
   public Carrito updateCarrito(@PathVariable("id") Long id, @Valid @RequestBody Carrito requestCarrito) {
      Carrito carrito = carritoRepository.findById(id).get();
      carrito.setDetalleCarrito(requestCarrito.getDetalleCarrito());
      return carritoRepository.save(carrito);
   }

   @DeleteMapping(value = "/carritos/{id}")
   public void deleteCarrito(@PathVariable("id") Long id) {
      carritoRepository.deleteById(id);
   }
}
