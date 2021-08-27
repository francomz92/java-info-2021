package com.spring_rest_LevelUno.tienda.controller;

import com.spring_rest_LevelUno.tienda.entity.Detalle;
import com.spring_rest_LevelUno.tienda.exceptions.ResourceNotFound;
import com.spring_rest_LevelUno.tienda.repository.CarritoRepository;
import com.spring_rest_LevelUno.tienda.repository.DetalleRepository;
import com.spring_rest_LevelUno.tienda.service.DetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class DetalleController {
   @Autowired
   private DetalleRepository detalleRepository;
   @Autowired
   private CarritoRepository carritoRepository;

   @Autowired
   private DetalleService detalleService;

   @GetMapping(value = "/detalles")
   public ResponseEntity<?> getDetalles() {
      return ResponseEntity.status(HttpStatus.OK).body(detalleRepository.findAll());
   }

   @GetMapping(value = "/detalles/{id}")
   public ResponseEntity<?> getDetalleById(@PathVariable("id") Long id) {
      Optional<Detalle> detalle = detalleRepository.findById(id);
      if (detalle.isEmpty()) {
         throw new ResourceNotFound("¡No existe el detalle solicitado!");
      }
      return ResponseEntity.status(HttpStatus.OK).body(detalle);
   }

   @PostMapping(value = "/detalles")
   public ResponseEntity<?> createDetalle(@Valid @RequestBody Detalle requestDetalle) {
      requestDetalle.setTotal();
      return ResponseEntity.status(HttpStatus.CREATED).body(detalleRepository.save(requestDetalle));
   }

   @PutMapping(value = "/detalles/{id}")
   public ResponseEntity<?> updateDetalle(@PathVariable("id") Long id, @Valid @RequestBody Detalle requestDetalle) {
      Optional<Detalle> detalle = detalleRepository.findById(id);
      if (detalle.isEmpty()) {
         throw new ResourceNotFound("¡No existe el detalle solicitado!");
      }
      detalleService.detalleEdition(detalle.get(), requestDetalle);
      return ResponseEntity.status(HttpStatus.OK).body(detalleRepository.save(detalle.get()));
   }

   @DeleteMapping(value = "/detalles/{id}")
   public ResponseEntity<?> deleteDetalle(@PathVariable("id") Long id) {
      Optional<Detalle> detalle = detalleRepository.findById(id);
      if (detalle.isEmpty()) {
         throw new ResourceNotFound("¡El detalle que intenta eliminar no existe!");
      }
      detalleRepository.deleteById(id);
      return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
   }
}
