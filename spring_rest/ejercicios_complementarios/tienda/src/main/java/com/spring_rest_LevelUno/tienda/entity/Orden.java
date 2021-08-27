package com.spring_rest_LevelUno.tienda.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orden")
public class Orden {

   @Id
   private Long id;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "FK_usuario")
   private Usuario usuario;

   @Transient
   private String comprador;

   @OneToMany(mappedBy = "orden", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   private List<Detalle> detalles = new ArrayList<>();

   private BigDecimal total;

   @CreationTimestamp
   private Instant fecha;

   private String tipoFactura;

   @Column(unique = true)
   private String codigoFactura;

   private String estado;

   public Orden() {
   }

   public Orden(Usuario usuario, List<Detalle> detalles, String tipoFactura, String numeroFactura, String estado) {
      this.usuario = usuario;
      this.detalles = detalles;
      this.tipoFactura = tipoFactura;
      this.codigoFactura = numeroFactura;
      this.estado = estado;
   }

   // Getters

   public Long getId() {
      return id;
   }

//   public Usuario getUsuario() {
//      return usuario;
//   }

   public List<Detalle> getDetalles() {
      return detalles;
   }

   public BigDecimal getTotal() {
      return total;
   }

   public Instant getFecha() {
      return fecha;
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

   public String getComprador() { return this.usuario.getNombre().concat(" ").concat(this.usuario.getApellido()); }

   // Setters


   public void setId(Long id) {
      this.id = id;
   }

   public void setUsuario(Usuario usuario) {
      this.usuario = usuario;
   }

   public void setDetalles(List<Detalle> detalles) {
      this.detalles = detalles;
   }

   public void setTotal(BigDecimal total) {
      this.total = total;
   }

   public void setFecha(Instant fecha) {
      this.fecha = fecha;
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
