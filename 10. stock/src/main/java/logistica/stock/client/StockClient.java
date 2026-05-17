package logistica.stock.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// "producto-service" debe ser el nombre exacto configurado en el application.properties de Producto
@FeignClient(name = "producto") 
public interface StockClient {

    // Apunta exactamente al GetMapping del SKU de tu ProductoController
    @GetMapping("/api/productos/sku/{sku}")
    ResponseEntity<?> buscarPorSku(@PathVariable("sku") String sku);
}