package logistica.stock.model;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stock")

public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, length = 20)
    private Long idStock;
    
    @NotBlank(message = "El ID de Ubicacion es obligatorio.")
    @Column(nullable = false)
    private String idUbicacion;
    
    @NotBlank(message = "El SKU es obligatorio.")
    @Column(nullable = false)
    private String sku;
    
    @NotNull(message = "La cantidad disponible es obligatorio.")
    @Column(nullable = false)
    private Integer cantDisponibles;

}
