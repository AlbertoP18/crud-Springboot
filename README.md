# Proyecto CRUD Spring Boot

Este proyecto es una API REST desarrollada con **Spring Boot** para la gestión de productos y usuarios. Implementa funcionalidades de CRUD (Crear, Leer, Actualizar y Eliminar) con validaciones básica y persistencia en base de datos mediante JPA.

## 📂 Estructura del Proyecto

La estructura del proyecto sigue la arquitectura estándar de Spring Boot con controladores, servicios, modelos, repositorios y configuración de seguridad.

## Explicación de cada carpeta

### 📁 config

Contiene la configuración de seguridad:

- **Seguridad.java**: Configura **CORS** y **Spring Security** para permitir solicitudes sin autenticación.

### 📁 controller

Controladores que manejan las solicitudes HTTP:

- **ProductoController.java**: CRUD para productos (listar, obtener, guardar, actualizar y eliminar).
- **UserController.java**: Endpoint para autenticación de usuarios.

### 📁 dto

Clases DTO (Data Transfer Object):

- **ProducResponseDto.java**: Respuesta con un mensaje y un objeto `Producto`.

### 📁 models

Clases de modelo que representan las entidades en la base de datos:

- **Producto.java**: Modelo para productos con validaciones.
- **User.java**: Modelo para usuarios con atributos como `nombre`, `contraseña` y `rol_id`.
- **Response.java**: Estructura de respuesta genérica para las operaciones de la API.

### 📁 repository

Interfaces de acceso a la base de datos usando **Spring Data JPA**:

- **IProductoRepository.java**: Repositorio para `Producto`.
- **IUserRepository.java**: Repositorio para `User`, con método personalizado `findByNombreAndContrasena` para autenticación.

### 📁 service

Lógica de negocio de la aplicación:

- **ProductoService.java**: Implementa las operaciones CRUD para productos.
- **UserService.java**: Implementa la autenticación de usuarios.
# 📌 API de Productos
### GET /productos

- **Ruta:**         /productos
- **Metodo:**       GET
- **Descripcion**   Devuelve un array con todos los productos 
### GET /productos/{id}

- **Ruta:**         /productos/{id}
- **Metodo:**       GET
- **Descripcion**   Devuelve la información de un producto basado en su id### GET /productos

- **Ruta:**         /productos/{id}
- **Metodo:**       GET
- **Descripcion**   Devuelve la información de un producto basado en su id

### POST /productos

- **Ruta:**         /productos
- **Metodo:**       POST
- **Descripcion**   Inserta un nuevo producto en la base de datos

  ### PUT /productos/{id}

- **Ruta:**         /productos/{id}
- **Metodo:**       PUT
- **Descripcion**   Actualiza un producto

### DELETE /productos/{id}

- **Ruta:**         /productos/{id}
- **Metodo:**       DELETE
- **Descripcion**   Elimina el producto con el id pasado en la url**
