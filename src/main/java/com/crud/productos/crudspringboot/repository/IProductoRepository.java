package com.crud.productos.crudspringboot.repository;

import com.crud.productos.crudspringboot.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto, Long> {
}
