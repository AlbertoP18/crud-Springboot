package com.crud.productos.crudspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Seguridad {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()  // Deshabilita CSRF (solo para desarrollo)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/productos/**").permitAll()  // Permite acceso a productos sin autenticación
                        .anyRequest().authenticated()
                )
                .httpBasic();  // Habilita autenticación básica para otros endpoints

        return http.build();
    }
}
