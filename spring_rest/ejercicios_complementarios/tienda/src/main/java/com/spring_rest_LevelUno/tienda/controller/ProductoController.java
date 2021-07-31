package com.spring_rest_LevelUno.tienda.controller;

import com.spring_rest_LevelUno.tienda.entity.Producto;
import com.spring_rest_LevelUno.tienda.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping(value = "/productos")
    public Iterable<Producto> getProductos(){
        return productoRepository.findAll();
    }

    @GetMapping(value = "/productos/{id}")
    public Optional<Producto> getUsuario(@PathVariable("id") Long id) {
        return productoRepository.findById(id);
    }

    @PostMapping(value = "/productos")
    public Producto createproducto(@Valid @RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @PutMapping(value = "/productos/{id}")
    public Producto updateProducto(@PathVariable("id") Long id, @Valid @RequestBody Producto requestProducto) {
        Producto producto = productoRepository.findById(id).get();
        producto.setNombre(requestProducto.getNombre());
        producto.setCategoria(requestProducto.getCategoria());
        producto.setDescripcion(requestProducto.getDescripcion());
        producto.setPrecioUnitario(requestProducto.getPrecioUnitario());
        return productoRepository.save(producto);
    }

    @DeleteMapping(value = "/productos/{id}")
    public void deleteProducto(@PathVariable("id") Long id) {
        productoRepository.deleteById(id);
    }
}
