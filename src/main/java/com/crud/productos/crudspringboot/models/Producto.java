package com.crud.productos.crudspringboot.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(nullable = false, unique = true)
    @Getter
    @Setter
    private String nombre;

    @Column(nullable = false)
    @Getter
    @Setter
    private Double precio;

    @Column(nullable = false)
    @Getter
    @Setter
    private Integer cantidad;


    public boolean Validaciones(){

        if (this.precio < 0){
            return false;
        }

        if(this.cantidad < 0 ){
            return false;
        }

        if(this.nombre == null || this.nombre.isEmpty()){
            return false;
        }

        return true;
    }

}
