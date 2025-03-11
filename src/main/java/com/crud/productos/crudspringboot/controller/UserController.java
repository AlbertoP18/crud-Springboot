package com.crud.productos.crudspringboot.controller;

import com.crud.productos.crudspringboot.models.Producto;
import com.crud.productos.crudspringboot.models.Response;
import com.crud.productos.crudspringboot.models.User;
import com.crud.productos.crudspringboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/credenciales")

    public ResponseEntity<User> login(@RequestBody User user) {
    User credenciales = userService.login(user.getNombre(), user.getContrasena());

        if (credenciales != null) {
           credenciales.setContrasena(null);
            return ResponseEntity.status(200).body(credenciales);
        }
    return ResponseEntity.status(404).body(user);
    }
}
