package com.crud.productos.crudspringboot.repository;

import com.crud.productos.crudspringboot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
