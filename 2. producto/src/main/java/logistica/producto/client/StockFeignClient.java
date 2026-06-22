package logistica.producto.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import logistica.producto.dto.StockDTO;

@FeignClient(name = "stock")
public interface StockFeignClient {

    @PostMapping("/api/stock")
    ResponseEntity<?> registrarOActualizar(@RequestBody StockDTO stock);
    
    @PostMapping("/api/stock/inicializar") 
    ResponseEntity<?> inicializarStock(@RequestBody StockDTO stock);
}