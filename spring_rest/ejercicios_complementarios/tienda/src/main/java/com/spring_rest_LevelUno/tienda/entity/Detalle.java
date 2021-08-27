package com.spring_rest_LevelUno.tienda.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "detalle")
public class Detalle {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @ManyToOne
   @JoinColumn(name = "FK_producto")
   private Producto producto;

   @JsonIgnore
   @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JoinColumn(name = "FK_carrito")
   private Carrito  carrito;

   @JsonIgnore
   @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JoinColumn(name = "FK_orden")
   private Orden orden;

   private Integer cantidad;
   private BigDecimal total;

   public Detalle(){}

   public Detalle(Producto producto, Integer cantidad) {
      this.producto = producto;
      this.cantidad = cantidad;
      this.total = this.getDefaulTotal();
   }


   //  -----> Getters Methods <-----

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

   public Carrito getCarrito() { return carrito; }

   public Orden getOrden() { return orden; }

   //  -----> Setters Methods <-----

   public void setProducto(Producto producto) { this.producto = producto; }

   public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

   public void setTotal() { this.total = this.producto.getPrecioUnitario().multiply(new BigDecimal(this.cantidad)); }

   public void setCarrito(Carrito carrito) {
      this.carrito = carrito;
   }

   public void setOrden(Orden orden) { this.orden = orden; }

   //   ------> Customs Methods <-----

   private BigDecimal getDefaulTotal() {
      assert this.producto != null;
      return this.producto.getPrecioUnitario().multiply(new BigDecimal(this.cantidad));
   }
}
