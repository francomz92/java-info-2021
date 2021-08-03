package com.spring_rest_LevelUno.tienda.repository;

import com.spring_rest_LevelUno.tienda.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {
//    ProductoRepository productoRepo = new ProductoRepository() {
//        @Override
//        public <S extends Producto> S save(S s) {
//            return null;
//        }
//
//        @Override
//        public <S extends Producto> Iterable<S> saveAll(Iterable<S> iterable) {
//            return null;
//        }
//
//        @Override
//        public Optional<Producto> findById(Long aLong) {
//            return Optional.empty();
//        }
//
//        @Override
//        public boolean existsById(Long aLong) {
//            return false;
//        }
//
//        @Override
//        public Iterable<Producto> findAll() {
//            return null;
//        }
//
//        @Override
//        public Iterable<Producto> findAllById(Iterable<Long> iterable) {
//            return null;
//        }
//
//        @Override
//        public long count() {
//            return 0;
//        }
//
//        @Override
//        public void deleteById(Long aLong) {
//
//        }
//
//        @Override
//        public void delete(Producto producto) {
//
//        }
//
//        @Override
//        public void deleteAllById(Iterable<? extends Long> iterable) {
//
//        }
//
//        @Override
//        public void deleteAll(Iterable<? extends Producto> iterable) {
//
//        }
//
//        @Override
//        public void deleteAll() {
//
//        }
//    };
//
//    public default Producto findByNombre(String nombre) {
//        List<Producto> productos = (List<Producto>) productoRepo.findAll();
//        AtomicReference<Producto> producto = null;
//        productos.forEach(element -> {
//            if (element.getNombre().equals(nombre)) {
//                producto.set(element);
//            }
//        });
//        return producto.get();
//    }
}
