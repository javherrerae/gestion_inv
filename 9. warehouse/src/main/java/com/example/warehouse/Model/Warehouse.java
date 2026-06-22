package com.example.warehouse.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "warehouse")
public class Warehouse {

    @Id
    @NotBlank(message = "El ID de ubicación es obligatorio")
    @Column(nullable = false, length = 6)
    private String idUbicacion;

    @NotBlank(message = "El pasillo es obligatorio")
    @Column(nullable = false, length = 4)
    private String pasillo;

    @NotBlank(message = "El rack es obligatorio")
    @Column(nullable = false, length = 4)
    private String rack;

    // Usamos Integer para permitir validaciones con @NotNull
    @NotNull(message = "El nivel es obligatorio")
    @Column(nullable = false)
    private Integer nivel;
}

/*
{
  "idUbicacion": "U001",
  "pasillo": "P01",
  "rack": "R01",
  "nivel": 1
}
*/