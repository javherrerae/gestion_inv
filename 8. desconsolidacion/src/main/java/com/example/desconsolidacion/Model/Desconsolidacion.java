package com.example.desconsolidacion.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "desconsolidacion")
public class Desconsolidacion {

    // Usamos Long porque el ID es autogenerado por la base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDesconsolidacion;

    @NotNull(message = "El número de factura es obligatorio")
    @Column(nullable = false)
    private Long nFactura;

    // Integer permite validar valores nulos
    @NotNull(message = "La cantidad de productos es obligatoria")
    @Column(nullable = false)
    private Integer cantidadProductos;
}

/*
{
  "nFactura": 1001,
  "cantidadProductos": 50

} */