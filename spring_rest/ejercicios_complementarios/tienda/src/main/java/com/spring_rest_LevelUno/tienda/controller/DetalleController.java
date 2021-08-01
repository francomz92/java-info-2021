package com.spring_rest_LevelUno.tienda.controller;

import com.spring_rest_LevelUno.tienda.entity.Detalle;
import com.spring_rest_LevelUno.tienda.repository.DetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class DetalleController {
   @Autowired
   DetalleRepository detalleRepository;

   @GetMapping(value = "/detalles")
   public Iterable<Detalle> getDetalles() {
      return detalleRepository.findAll();
   }

   @GetMapping(value = "/detalles/{id}")
   public Optional<Detalle> getDetalle(@PathVariable("id") Long id) {
      return detalleRepository.findById(id);
   }

   @PostMapping(value = "/detalles")
   public Detalle createDetalle(@Valid @RequestBody Detalle requestDetalle) {
      requestDetalle.setTotal();
      return detalleRepository.save(requestDetalle);
   }

   @PutMapping(value = "/detalles/{id}")
   public Detalle updateDetalle(@PathVariable("id") Long id, @Valid @RequestBody Detalle requestDetalle) {
      Detalle detalle = detalleRepository.findById(id).get();
      detalle.setCantidad(requestDetalle.getCantidad());
      detalle.setTotal();
      return detalleRepository.save(detalle);
   }

   @DeleteMapping(value = "/detalles/{id}")
   public void deleteDetalle(@PathVariable("id") Long id) {
      detalleRepository.deleteById(id);
   }
}
