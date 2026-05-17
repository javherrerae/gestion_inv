package com.example.camion.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "camion")
public class Camion {

    @Id
    @Column(nullable = false, length = 6)
    private String patente;

    @Column(nullable = false, length = 20)
    @NotBlank
    private String nombreConductor;

    @Column(nullable = false, length = 12)
    @NotBlank
    private String rutConductor;
    
//   {
//"patente": "AB1234",
//"nombreConductor": "Juan Perez",
//"rutConductor": "11111111-1"
//}
}
