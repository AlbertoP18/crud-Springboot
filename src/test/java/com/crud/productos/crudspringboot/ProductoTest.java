package com.crud.productos.crudspringboot;

import com.crud.productos.crudspringboot.models.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductoTest {
    @Test
    public void testProductoValidoCorrecto(){
        Producto producto = new Producto();

        producto.setNombre("Laptop");
        producto.setPrecio(90.0);
        producto.setCantidad(20);

        assertTrue(producto.Validaciones());
    }

    @Test
    public void testProductoValidoPrecioNegativo() {
        Producto producto = new Producto();
        producto.setNombre("Laptop");
        producto.setPrecio(-100.0);
        producto.setCantidad(10);

        assertFalse(producto.Validaciones());
    }

    @Test
    public void testProductoValidoCantidadNegativa() {
        Producto producto = new Producto();
        producto.setNombre("Laptop");
        producto.setPrecio(500.0);
        producto.setCantidad(-5);

        assertFalse(producto.Validaciones());
    }

    @Test
    public void testProductoValidoNombreNulo() {
        Producto producto = new Producto();
        producto.setNombre(null);
        producto.setPrecio(500.0);
        producto.setCantidad(10);

        assertFalse(producto.Validaciones());
    }

    @Test
    public void testProductoValidoNombreVacio() {
        Producto producto = new Producto();
        producto.setNombre("");
        producto.setPrecio(500.0);
        producto.setCantidad(10);

        assertFalse(producto.Validaciones());
    }
}
