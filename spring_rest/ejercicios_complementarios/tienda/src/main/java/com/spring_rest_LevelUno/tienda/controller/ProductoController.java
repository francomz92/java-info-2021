package com.spring_rest_LevelUno.tienda.controller;

import com.spring_rest_LevelUno.tienda.entity.Producto;
import com.spring_rest_LevelUno.tienda.exceptions.ResourceNotFound;
import com.spring_rest_LevelUno.tienda.repository.CarritoRepository;
import com.spring_rest_LevelUno.tienda.repository.DetalleRepository;
import com.spring_rest_LevelUno.tienda.repository.ProductoRepository;
import com.spring_rest_LevelUno.tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoService productoService;


    @GetMapping(value = "/productos")
    public ResponseEntity<?> getProductos(){
        return ResponseEntity.status(HttpStatus.OK).body(productoRepository.findAll());
    }

    @GetMapping(value = "/productos/{id}")
    public ResponseEntity<?> getProductoById(@PathVariable("id") Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isEmpty()) {
            throw new ResourceNotFound("¡No existe el producto solicitado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(producto);
    }

    @GetMapping(value = "/productos/Qn")
    public ResponseEntity<?> getProductoByNombre(@RequestParam("nombre") String nombre) {
        List<Producto> productos = productoRepository.findByNombreContaining(nombre);
        if (productos.isEmpty()) {
            throw new ResourceNotFound("¡No se encontraron productos con el nombre '".concat(nombre).concat("'!"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(productos);
    }

    @GetMapping(value = "/productos/Qc")
    public ResponseEntity<?> getProductoByCategoria(@RequestParam("categoria") String categoria) {
        List<Producto> productos = productoRepository.findByCategoria(categoria);
        if (productos.isEmpty()) {
            throw new ResourceNotFound("¡No se encontraron productos en la categoría '".concat(categoria).concat("'!"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(productos);
    }

    @PostMapping(value = "/productos")
    public ResponseEntity<?> createProducto(@Valid @RequestBody Producto producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoRepository.save(producto));
    }

    @PutMapping(value = "/productos/{id}")
    public ResponseEntity<?> updateProducto(@PathVariable("id") Long id, @Valid @RequestBody Producto requestProducto) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isEmpty()) {
            throw new ResourceNotFound("¡No existe el producto solicitado!");
        }
        productoService.productoEdition(producto.get(), requestProducto);
        return ResponseEntity.status(HttpStatus.OK).body(productoRepository.save(producto.get()));
    }

    @DeleteMapping(value = "/productos/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable("id") Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isEmpty()) {
            throw new ResourceNotFound("¡El producto que quiere eliminar no existe!");
        }
        productoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
    }
}
