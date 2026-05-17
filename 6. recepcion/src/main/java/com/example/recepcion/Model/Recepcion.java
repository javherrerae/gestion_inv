package com.example.recepcion.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "recepcion")
public class Recepcion {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecepcion;

    // Usamos Long porque es más fácil trabajarla con la base de datos, además nos permite null.
    @NotNull(message = "El número de anden es obligatorio")
    @Column(nullable = false)
    private Long nAnden;

    @NotBlank(message = "La patente es obligatoria")
    @Column(nullable = false, length = 6)
    private String patente;

    @NotNull(message = "La fecha y hora de recepcion es obligatoria")
    @Column(nullable = false)
    private LocalDateTime fechaHoraRecepcion;

    @NotBlank(message = "El estado es obligatorio")
    @Column(nullable = false, length = 20)
    private String estado;

//{
//  "nAnden": 1,
//  "patente": "AB1234",
//  "fechaHoraRecepcion": "2026-05-14T10:30:00",
//  "estado": "RECIBIDO"
//}
}
