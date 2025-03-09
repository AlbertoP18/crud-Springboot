package com.crud.productos.crudspringboot.controller;

import com.crud.productos.crudspringboot.models.Producto;
import com.crud.productos.crudspringboot.models.Response;
import com.crud.productos.crudspringboot.repository.IProductoRepository;
import com.crud.productos.crudspringboot.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/list")
        public List<Producto> obtenerProductos() {
            return productoService.findAll();
        }


    @GetMapping("/{id}")
    public ResponseEntity<Response> obtenerProducto(@PathVariable Long id) {
        Producto producto = productoService.findById(id);
        if (producto != null) {
            return ResponseEntity.status(200)
                    .body(new Response(true, "Producto encontrado" ));
        } else {
            return ResponseEntity.status(404)
                    .body(new Response(false, "Producto no encontrado"));
        }
    }


    @PostMapping("/save")
    public ResponseEntity<Response> guardarProducto(@RequestBody Producto producto) {

        if (!producto.Validaciones()) {
            return ResponseEntity.status(400)
                    .body(new Response(false, "Datos inválidos: el nombre no puede estar vacío y el precio/cantidad no pueden ser negativos"));
        }

        Producto nuevoProducto = productoService.save(producto);
        return ResponseEntity.status(201)
                .body(new Response(true, "Producto guardado correctamente"));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> actualizarProducto(@RequestBody Producto producto, @PathVariable Long id) {

        if (!producto.Validaciones()) {
            return ResponseEntity.status(400)
                    .body(new Response(false, "Datos inválidos: el nombre no puede estar vacío y el precio/cantidad no pueden ser negativos"));
        }


        Producto actualizado = productoService.update(producto, id);

        if (actualizado != null) {
            return ResponseEntity.status(200)
                    .body(new Response(true, "Producto actualizado correctamente"));
        } else {
            return ResponseEntity.status(404)
                    .body(new Response(false, "No se pudo actualizar el producto "));
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Response> eliminarProducto(@PathVariable Long id) {
        Producto producto = productoService.findById(id);

        if (producto != null) {
            productoService.delete(id);
            return ResponseEntity.status(200)
                    .body(new Response(true, "Producto eliminado correctamente"));
        } else {
            return ResponseEntity.status(404)
                    .body(new Response(false, "Producto no encontrado"));
        }
    }

}











