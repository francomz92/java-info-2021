package com.spring_rest_LevelUno.tienda.service;

import com.spring_rest_LevelUno.tienda.dto.OrdenDTO;
import com.spring_rest_LevelUno.tienda.entity.Carrito;
import com.spring_rest_LevelUno.tienda.entity.Orden;
import com.spring_rest_LevelUno.tienda.entity.Usuario;
import com.spring_rest_LevelUno.tienda.repository.CarritoRepository;
import com.spring_rest_LevelUno.tienda.repository.DetalleRepository;
import com.spring_rest_LevelUno.tienda.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OrdenService {

   @Autowired
   private DetalleRepository detalleRepository;
   @Autowired
   private OrdenRepository ordenRepository;
   @Autowired
   private CarritoRepository carritoRepository;


   public Orden createCompra(OrdenDTO compraDTO, Usuario usuario) {
      Orden compra = new Orden();
      compra.setId(compraDTO.getCarrito().getId());
      compra.setCodigoFactura(compraDTO.getCodigoFactura());
      compra.setDetalles(compraDTO.getCarrito().getDetalles());
      compra.setEstado(compraDTO.getEstado());
      compra.setTipoFactura(compraDTO.getTipoFactura());
      compra.setUsuario(usuario);
      compra.setTotal(compraDTO.getCarrito().getTotal());

      updateUsuarioCarritosandUsuarioCompras(usuario, compra, compraDTO.getCarrito());

      compra.getDetalles().forEach(detalle -> {
         detalle.setOrden(compra);
         detalleRepository.save(detalle);
      });
      return compra;
   }

   public void updateUsuarioCarritosandUsuarioCompras(Usuario usuario, Orden compra, Carrito carrito) {
      usuario.getCarritos().remove(carrito);
      Carrito carrito1 = carritoRepository.getById(compra.getId());
      carrito1.setUsuario(null);
   }
}

