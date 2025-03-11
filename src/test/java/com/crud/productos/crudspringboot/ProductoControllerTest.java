package com.crud.productos.crudspringboot;

import com.crud.productos.crudspringboot.controller.ProductoController;
import com.crud.productos.crudspringboot.dto.ProducResponseDto;
import com.crud.productos.crudspringboot.models.Producto;
import com.crud.productos.crudspringboot.models.Response;
import com.crud.productos.crudspringboot.service.ProductoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ProductoControllerTest {

    @Mock
    private ProductoService productoService;

    @InjectMocks
    private ProductoController productoController;

    private Producto producto1, producto2, productoNuevo;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);

        producto1 = new Producto();
        producto1.setId(1L);
        producto1.setNombre("Teclado");
        producto1.setPrecio(100.0);
        producto1.setCantidad(20);

        producto2 = new Producto();
        producto2.setId(2L);
        producto2.setNombre("Ratón");
        producto2.setPrecio(50.0);
        producto2.setCantidad(15);

        productoNuevo = new Producto();
        productoNuevo.setNombre("Laptop Gamer");
        productoNuevo.setPrecio(199.99);
        productoNuevo.setCantidad(10);
    }

    @Test
    public void testObtenerTodosLosProductos() {
        when(productoService.findAll()).thenReturn(Arrays.asList(producto1, producto2));

        List<Producto> productos = productoController.obtenerProductos();
        assertNotNull(productos);
        assertEquals(2, productos.size());
    }

    @Test
    public void testObtenerProductoPorIdExistente() {
        when(productoService.findById(1L)).thenReturn(producto1);

        ResponseEntity<ProducResponseDto> response = productoController.obtenerProducto(1L);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("producto encontrado", response.getBody().getMensaje());
        assertEquals(producto1, response.getBody().getProducto());
    }

    @Test
    public void testObtenerProductoPorIdNoExistente() {
        when(productoService.findById(3L)).thenReturn(null);

        ResponseEntity<ProducResponseDto> response = productoController.obtenerProducto(3L);
        assertEquals(404, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("producto no encontrado", response.getBody().getMensaje());
        assertNull(response.getBody().getProducto());
    }

    @Test
    public void testGuardarProductoExitoso() {
        when(productoService.save(any(Producto.class))).thenReturn(productoNuevo);

        ResponseEntity<Response> response = productoController.guardarProducto(productoNuevo);
        assertEquals(201, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().isSuccess());
        assertEquals("Producto guardado correctamente", response.getBody().getMessage());
    }

    @Test
    public void testGuardarProductoInvalido() {
        productoNuevo.setPrecio(-10.0); // Precio inválido
        ResponseEntity<Response> response = productoController.guardarProducto(productoNuevo);

        assertEquals(400, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isSuccess());
        assertEquals("Datos inválidos: el nombre no puede estar vacío y el precio/cantidad no pueden ser negativos", response.getBody().getMessage());
    }

    @Test
    public void testActualizarProductoExistente() {
        when(productoService.update(any(Producto.class), eq(1L))).thenReturn(producto1);

        ResponseEntity<Response> response = productoController.actualizarProducto(producto1, 1L);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().isSuccess());
        assertEquals("Producto actualizado correctamente", response.getBody().getMessage());
    }

    @Test
    public void testActualizarProductoNoExistente() {
        when(productoService.update(any(Producto.class), eq(3L))).thenReturn(null);

        ResponseEntity<Response> response = productoController.actualizarProducto(producto1, 3L);
        assertEquals(404, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isSuccess());
        assertEquals("No se pudo actualizar el producto ", response.getBody().getMessage());
    }

    @Test
    public void testEliminarProductoExistente() {
        when(productoService.findById(1L)).thenReturn(producto1);
        doNothing().when(productoService).delete(1L);

        ResponseEntity<Response> response = productoController.eliminarProducto(1L);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().isSuccess());
        assertEquals("Producto eliminado correctamente", response.getBody().getMessage());
    }

    @Test
    public void testEliminarProductoNoExistente() {
        when(productoService.findById(3L)).thenReturn(null);

        ResponseEntity<Response> response = productoController.eliminarProducto(3L);
        assertEquals(404, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isSuccess());
        assertEquals("Producto no encontrado", response.getBody().getMessage());
    }
}
