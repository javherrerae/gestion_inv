package logistica.producto.model;

import java.time.LocalDate;

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
@Table(name = "productos")

public class Producto {

    // Usamos nuestro SKU como ID. Para no tener problemas de CamelCase, escribimos sku en minúsculas. 
    @Id
    @NotBlank(message = "El SKU es obligatorio")
    @Column(nullable = false, unique = true, length = 20)
    private String sku;

    @NotNull(message = "El ID de desconsolidación es obligatorio")
    @Column(nullable = false)
    private Long idDesconsolidacion;

    @NotBlank(message = "El nombre del producto es obligatorio")
    @Column(nullable = false, length = 100)
    private String nombreProducto;

    @NotBlank(message = "La categoría no puede estar vacía")
    @Column(nullable = false, length = 50)
    private String categoria;

    @NotNull(message = "La fecha de fabricación es obligatoria")
    @Column(nullable = false)
    private LocalDate fecFabricacion;
    
    // No todos los productos tienen fecha de caducidad
    @Column(nullable = true)
    private LocalDate fecCaducidad;

/*
{
  "sku": "LECHE001",
  "idDesconsolidacion": 2,
  "nombreProducto": "Leche Descremada 1L",
  "categoria": "ALIMENTOS",
  "fecFabricacion": "2026-05-01",
  "fecCaducidad": "2026-06-15"
}

{
  "sku": "SKU12345",
  "idDesconsolidacion": 1,
  "nombreProducto": "Telefono Samsung S25",
  "categoria": "ELECTRONICA",
  "fecFabricacion": "2026-05-15",
  "fecCaducidad": null
}
*/


}