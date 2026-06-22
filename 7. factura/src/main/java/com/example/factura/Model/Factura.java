package com.example.factura.Model;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "factura")
public class Factura {

    // Usaremos n° factura como String por flexibilidad de poder usar una factura como Código: FAC00001
    @Id
    @NotBlank(message = "El n° de factura es obligatorio")
    @Column(nullable = false, length = 20)
    private String numeroFactura;

    @NotNull(message = "El ID de recepcion es obligatorio")
    @Column(nullable = false)
    private Long idRecepcion;

    @NotBlank(message = "El proveedor es obligatorio")
    @Column(nullable = false, length = 80)
    private String proveedor;

    @NotNull(message = "La fecha de factura es obligatoria")
    @Column(nullable = false)
    private LocalDate fechaFactura;
    
    @NotNull(message = "La cantidad de cajas es obligatoria")
    @Column(nullable = false)
    private Integer cantidadCajas;

    @NotBlank(message = "El estado de la factura es obligatorio")
    @Column(nullable = false, length = 30)
    private String estado;

/* JSON
{
  "nFactura": "FAC001",
  "idRecepcion": 1,
  "proveedor": "Proveedor Central",
  "fechaFactura": "2026-05-14",
  "cantidadCajas": 25,
  "estado": "REGISTRADA"
}
REGISTRADA
EN_REVISION
VALIDADA
RECHAZADA

*/

}
