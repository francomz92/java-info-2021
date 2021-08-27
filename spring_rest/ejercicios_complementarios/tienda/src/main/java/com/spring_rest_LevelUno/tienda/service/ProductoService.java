package com.spring_rest_LevelUno.tienda.service;

import com.spring_rest_LevelUno.tienda.entity.Carrito;
import com.spring_rest_LevelUno.tienda.entity.Detalle;
import com.spring_rest_LevelUno.tienda.entity.Producto;
import com.spring_rest_LevelUno.tienda.repository.CarritoRepository;
import com.spring_rest_LevelUno.tienda.repository.DetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

   @Autowired
   private DetalleRepository detalleRepository;
   @Autowired
   private CarritoRepository carritoRepository;

   public void productoEdition(Producto producto, Producto requestProducto) {
      producto.setNombre(requestProducto.getNombre());
      producto.setCategoria(requestProducto.getCategoria());
      producto.setDescripcion(requestProducto.getDescripcion());
      producto.setPrecioUnitario(requestProducto.getPrecioUnitario());
      updateTotalDetallesAndTotalCarritos();
   }

   public void updateTotalDetallesAndTotalCarritos() {
      Iterable<Detalle> detalles = detalleRepository.findAll();
      Iterable<Carrito> carritos = carritoRepository.findAll();
      detalles.forEach(Detalle::setTotal);
      carritos.forEach(Carrito::setFinalTotal);
   }
}
