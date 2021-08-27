package com.spring_rest_LevelUno.tienda.service;

import com.spring_rest_LevelUno.tienda.entity.Carrito;
import com.spring_rest_LevelUno.tienda.entity.Usuario;
import com.spring_rest_LevelUno.tienda.repository.DetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoService {

   @Autowired
   private DetalleRepository detalleRepository;

   public void prepareCarritoCreation(Usuario usuario, Carrito requestCarrito) {
      requestCarrito.setUsuario(usuario);
      requestCarrito.getDetalles().forEach(detalle -> {
         detalle.setTotal();
         detalle.setCarrito(requestCarrito);
         detalleRepository.save(detalle);
      });
      requestCarrito.setFinalTotal();
      usuario.addCarrito(requestCarrito);
   }

   public void prepareCarritoEdition(Usuario usuario, Carrito carrito, Carrito requestCarrito){
      requestCarrito.getDetalles().forEach(detalle -> {
         detalle.setCarrito(carrito);
         detalle.setTotal();
         if (detalle.getCantidad().equals(0)) {
            requestCarrito.getDetalles().remove(detalle);
         }
      });
      carrito.setDetalles(requestCarrito.getDetalles());
   }
}
