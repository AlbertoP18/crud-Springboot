package com.crud.productos.crudspringboot.repository;

import com.crud.productos.crudspringboot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {


    Optional<User> findByNombreAndContrasena(String nombre, String contrasena);
}
