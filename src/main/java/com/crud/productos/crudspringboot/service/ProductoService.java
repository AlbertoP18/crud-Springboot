package com.crud.productos.crudspringboot.service;

import com.crud.productos.crudspringboot.models.Producto;
import com.crud.productos.crudspringboot.repository.IProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductoService {

    private final IProductoRepository productoRepository;


    public List<Producto> findAll() {
          return productoRepository.findAll();
    }

    public Producto findById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }


    public void delete( long id) {
        productoRepository.deleteById(id);
    }


    public Producto update(Producto producto, Long id) {
        Producto old = findById(id);
        old.setNombre(producto.getNombre());
        old.setPrecio(producto.getPrecio());
        old.setCantidad(producto.getCantidad());
        return productoRepository.save(old);
    }

}
