package com.crud.productos.crudspringboot.dto;

import com.crud.productos.crudspringboot.models.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProducResponseDto {

   private  String mensaje;
    private Producto producto;
}
