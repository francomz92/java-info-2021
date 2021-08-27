package com.spring_rest_LevelUno.tienda.dto;

import com.spring_rest_LevelUno.tienda.entity.Carrito;


public class OrdenDTO {

   private Carrito carrito;
   private String tipoFactura;

   private String codigoFactura;

   private String estado;

   public OrdenDTO(Carrito carrito, String tipoFactura, String codigoFactura, String estado) {
      this.carrito = carrito;
      this.tipoFactura = tipoFactura;
      this.codigoFactura = codigoFactura;
      this.estado = estado;
   }

   // Getters

   public Carrito getCarrito() {
      return carrito;
   }

   public String getTipoFactura() {
      return tipoFactura;
   }

   public String getCodigoFactura() {
      return codigoFactura;
   }

   public String getEstado() {
      return estado;
   }

   // Setters

   public void setCarrito(Carrito carrito) {
      this.carrito = carrito;
   }

   public void setTipoFactura(String tipoFactura) {
      this.tipoFactura = tipoFactura;
   }

   public void setCodigoFactura(String codigoFactura) {
      this.codigoFactura = codigoFactura;
   }

   public void setEstado(String estado) {
      this.estado = estado;
   }
}
