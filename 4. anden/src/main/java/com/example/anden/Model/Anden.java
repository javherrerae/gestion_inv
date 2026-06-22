package com.example.anden.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "anden")
public class Anden {

    @Id
    @Column(nullable = false)
    private Long numeroanden;

    @Column(nullable = false)
    @NotBlank
    private String estado;      // Disponible, ocupado

}
