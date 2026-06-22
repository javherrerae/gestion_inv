package logistica.producto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockDTO {
    private String sku;
    private String idUbicacion;
    private Integer cantDisponibles;

    public StockDTO(String sku, String idUbicacion, int cantDisponibles) {
        this.sku = sku;
        this.idUbicacion = idUbicacion;
        this.cantDisponibles = cantDisponibles;
    }
}