package com.crud.productos.crudspringboot.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Response {


    @Getter
    @Setter
    boolean success;

    @Getter
    @Setter
    String message;


    public void Message(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
