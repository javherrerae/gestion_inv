package logistica.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import logistica.stock.model.Stock;
import logistica.stock.service.StockServiceServ;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    @Autowired
    private StockServiceServ service;

    // 1. Listar todo el stock disponible en la empresa
    @GetMapping
    public ResponseEntity<List<Stock>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    // Endpoint exclusivo para ser consumido de manera inter-servicio
    @PostMapping("/inicializar")
    public ResponseEntity<Stock> inicializarStock(@RequestBody Stock stock) {
        Stock nuevoStock = service.inicializarStock(stock);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoStock);
}

    // 2. Registrar nuevo stock o incrementar existencias si ya existe en la ubicación
    @PostMapping
    public ResponseEntity<?> registrarOActualizar(@RequestBody Stock stock) {
        try {
            Stock nuevoStock = service.registrarOActualizar(stock);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoStock);
        } catch (RuntimeException e) {
            // Captura las excepciones de lógica de negocio (ej: si el SKU no existe en Eureka)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // 3. Buscar stock de un producto específico mediante su SKU
    @GetMapping("/producto/sku/{sku}")
    public ResponseEntity<List<Stock>> buscarPorSku(@PathVariable String sku) {
        return ResponseEntity.ok(service.buscarPorSku(sku));
    }

    // 4. Buscar qué productos hay guardados en una ubicación de la bodega
    @GetMapping("/ubicacion/{idUbicacion}")
    public ResponseEntity<List<Stock>> buscarPorUbicacion(@PathVariable String idUbicacion) {
        return ResponseEntity.ok(service.buscarPorUbicacion(idUbicacion));
    }

    /* 
    // 5. Descontar stock (Simula una salida de mercancía o un movimiento interno)
    @PutMapping("/descontar")
    public ResponseEntity<?> descontarStock(
            @RequestParam String sku,
            @RequestParam String idUbicacion,
            @RequestParam Integer cantidad) {
        try {
            Stock stockActualizado = service.descontarStock(sku, idUbicacion, cantidad);
            return ResponseEntity.ok(stockActualizado);
        } catch (RuntimeException e) {
            // Captura errores como "Stock insuficiente"
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // 6. Reporte de alertas: Obtener stock crítico por debajo de un límite
    @GetMapping("/critico/{limite}")
    public ResponseEntity<List<Stock>> obtenerStockCritico(@PathVariable Integer limite) {
        return ResponseEntity.ok(service.obtenerStockCritico(limite));
    }
        */
}