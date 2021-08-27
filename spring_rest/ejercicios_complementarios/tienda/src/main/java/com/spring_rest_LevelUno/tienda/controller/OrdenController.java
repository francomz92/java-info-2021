package com.spring_rest_LevelUno.tienda.controller;

import com.spring_rest_LevelUno.tienda.dto.OrdenDTO;
import com.spring_rest_LevelUno.tienda.entity.Orden;
import com.spring_rest_LevelUno.tienda.entity.Usuario;
import com.spring_rest_LevelUno.tienda.exceptions.ResourceNotFound;
import com.spring_rest_LevelUno.tienda.repository.CarritoRepository;
import com.spring_rest_LevelUno.tienda.repository.DetalleRepository;
import com.spring_rest_LevelUno.tienda.repository.OrdenRepository;
import com.spring_rest_LevelUno.tienda.repository.UsuarioRepository;
import com.spring_rest_LevelUno.tienda.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class OrdenController {

   @Autowired
   private OrdenRepository ordenRepository;
   @Autowired
   private UsuarioRepository usuarioRepository;

   @Autowired
   private OrdenService ordenService;

   @GetMapping(value = "/usuarios/{idUsuario}/compras")
   public ResponseEntity<?> getCompras(@PathVariable("idUsuario") Long idUsuario) {
      return ResponseEntity.status(HttpStatus.OK).body(ordenRepository.findAll());
   }

   @GetMapping(value = "/usuarios/{idUsuario/compras/{idCompra}")
   public ResponseEntity<?> getCompraById(@PathVariable("idUsuario") Long idUsuario, @PathVariable("idCompra") Long idCompra) {
      Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
      Optional<Orden> compra = ordenRepository.findById(idCompra);
      if (usuario.isEmpty() || compra.isEmpty() || !usuario.get().getCompras().contains(compra.get())) {
         throw new ResourceNotFound("¡Los datos de la compra no coinciden!");
      }
      return ResponseEntity.status(HttpStatus.OK).body(compra);
   }

   @PostMapping(value = "/usuarios/{idUsuario}/compras")
   public ResponseEntity<?> createCompra(@PathVariable("idUsuario") Long idUsuario, @Valid @RequestBody OrdenDTO compraDTO) {
      Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
      if (usuario.isEmpty()) {
         throw new ResourceNotFound("¡No se encontro el usuario solicitado!");
      }
      Orden compra = ordenService.createCompra(compraDTO, usuario.get());

//      carritoRepository.deleteById(compra.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(ordenRepository.findById(compraDTO.getCarrito().getId()));
   }

//   @PutMapping(value = "/usuarios/{idUsuario}/compras/{idCompra}")
//   public ResponseEntity<?> updateCompra(@PathVariable("idUsuario") Long idUsuario, @PathVariable("idCompra") Long idCompra, @Valid @RequestBody OrdenDTO compraDTO) {
//      Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
//      Optional<Orden> compra = ordenRepository.findById(idCompra);
//      if (usuario.isEmpty() || compra.isEmpty() || !usuario.get().getCompras().contains(compra.get())) {
//         throw new ResourceNotFound("¡No existe el recurso solicitado!");
//      }
//      compra.get().setEstado(compraDTO.getEstado());
//      return ResponseEntity.status(HttpStatus.OK).body(compra);
//   }

   @DeleteMapping(value = "/usuarios/{idUsuario}/compras/{idCompra}")
   public ResponseEntity<?> deleteCompra(@PathVariable("idUsuario") Long idUsuario, @PathVariable("idCompra") Long idCompra) {
      Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
      Optional<Orden> compra = ordenRepository.findById(idCompra);
      if (usuario.isEmpty() || compra.isEmpty() || !usuario.get().getCompras().contains(compra.get())) {
         throw new ResourceNotFound("¡No existe el recurso solicitado!");
      }
      ordenRepository.deleteById(idCompra);
      return ResponseEntity.status(HttpStatus.OK).build();
   }
}
