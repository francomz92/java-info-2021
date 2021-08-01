package com.spring_rest_LevelUno.tienda.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Detalle {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ManyToOne
   private Producto producto;
   private Integer cantidad;
   private BigDecimal total;

   public Detalle(Producto producto, Integer cantidad) {
      this.producto = producto;
      this.cantidad = cantidad;
      this.total = this.getDefaulTotal();
   }
   public Detalle(){}

   public Long getId() {
      return id;
   }

   public Producto getProducto() {
      return producto;
   }

   public Integer getCantidad() {
      return cantidad;
   }

   public BigDecimal getTotal() {
      return total;
   }

   public void setProducto(Producto producto) {
      this.producto = producto;
   }

   public void setCantidad(Integer cantidad) {
      this.cantidad = cantidad;
   }

   private BigDecimal getDefaulTotal() {
      assert this.producto != null;
      return this.producto.getPrecioUnitario().multiply(new BigDecimal(this.cantidad));
   }

   public void setTotal() {
      this.total = this.producto.getPrecioUnitario().multiply(new BigDecimal(this.cantidad));
   }
}
