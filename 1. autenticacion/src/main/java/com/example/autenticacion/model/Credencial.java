package com.example.autenticacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table  // NOMBRE DE LA TABLA // EL EUREKA NOS CONECTA A LA BASE DE DATOS, UTILIZAMOS EL XAMPP PARA LEVANTARLO
public class Credencial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String usuario;

    @Column(nullable = false)
    private String password;
    
    private Boolean is_active;
}
