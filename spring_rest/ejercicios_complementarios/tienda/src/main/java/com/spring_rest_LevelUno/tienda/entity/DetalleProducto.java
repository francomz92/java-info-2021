package com.spring_rest_LevelUno.tienda.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class DetalleProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Producto detalleProducto;
    private Long cantidad;
    private BigDecimal precioUnitarioProducto;
    private BigDecimal precioTotal;

    public DetalleProducto(Producto detalleProducto, Long cantidad, BigDecimal precioTotal) {
        this.detalleProducto = detalleProducto;
        this.cantidad = cantidad;
        this.precioUnitarioProducto = detalleProducto.getPrecioUnitario();
        this.precioTotal = precioTotal;
    }

    public Long getId() {
        return id;
    }

    public Producto getDetalleProducto() {
        return detalleProducto;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public BigDecimal getPrecioUnitarioProducto() {
        return precioUnitarioProducto;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setDetalleProducto(Producto detalleProducto) {
        this.detalleProducto = detalleProducto;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioUnitarioProducto(BigDecimal precioUnitarioProducto) {
        this.precioUnitarioProducto = precioUnitarioProducto;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }
}
