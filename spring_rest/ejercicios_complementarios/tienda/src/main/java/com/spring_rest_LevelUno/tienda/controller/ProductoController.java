package com.spring_rest_LevelUno.tienda.controller;

import com.spring_rest_LevelUno.tienda.entity.Producto;
import com.spring_rest_LevelUno.tienda.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
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
    public Optional<Producto> getProductoById(@PathVariable("id") Long id) {
        return productoRepository.findById(id);
    }

    @GetMapping(value = "/productos/Qs")
    public List<Producto> getProductoByNombre(@RequestParam("nombre") String nombre) {
        return productoRepository.findByNombreContaining(nombre);
    }

    @PostMapping(value = "/productos")
    public Producto createProducto(@Valid @RequestBody Producto producto) {
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
