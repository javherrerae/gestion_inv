package com.example.Usuario.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false, length = 80)
    private String nombre;

    @NotBlank(message = "El rut es obligatorio")
    @Column(nullable = false, unique = true, length = 15)
    private String rut;

    @NotBlank(message = "El correo es obligatorio")
    @Column(nullable = false, unique = true, length = 100)
    private String correo;

    @NotBlank(message = "El cargo es obligatorio")
    @Column(nullable = false, length = 50)
    private String cargo;

    @NotBlank(message = "El rol es obligatorio")
    @Column(nullable = false, length = 30)
    private String rol;

    @Column(nullable = false, length = 30)
    private String turno;

    @Column(nullable = false)
    private Boolean activo = true;
}

/*{
  "nombre": "Juan Perez",
  "rut": "11111111-1",
  "correo": "juan.perez@empresa.cl",
  "cargo": "Operario de Recepcion",
  "rol": "OPERARIO_RECEPCION",
  "turno": "MAÑANA",
  "activo": true
} */
