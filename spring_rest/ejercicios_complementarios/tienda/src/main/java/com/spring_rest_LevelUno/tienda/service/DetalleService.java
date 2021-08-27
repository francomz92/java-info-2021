package com.spring_rest_LevelUno.tienda.service;

import com.spring_rest_LevelUno.tienda.entity.Carrito;
import com.spring_rest_LevelUno.tienda.entity.Detalle;
import com.spring_rest_LevelUno.tienda.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleService {

   @Autowired
   private CarritoRepository carritoRepository;

   public void detalleEdition(Detalle detalle, Detalle requestDetalle) {
      detalle.setCantidad(requestDetalle.getCantidad());
      detalle.setTotal();
      updateCarritosTotal();
   }

   public void updateCarritosTotal() {
      Iterable<Carrito> carritos = carritoRepository.findAll();
      carritos.forEach(Carrito::setFinalTotal);
   }
}
