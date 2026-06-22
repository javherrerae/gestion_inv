package logistica.stock;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {

    private String sku;
    private Long idDesconsolidacion;
    private String nombreProducto;
    private String categoria;
    private LocalDate fecFabricacion;
    private LocalDate fecCaducidad;
}