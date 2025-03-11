package com.crud.productos.crudspringboot.service;

import com.crud.productos.crudspringboot.models.User;
import com.crud.productos.crudspringboot.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
private final IUserRepository userRepository;

 public User login(String nombre, String contrasena) {
     return userRepository.findByNombreAndContrasena(nombre, contrasena).orElse(null);
 }
}
