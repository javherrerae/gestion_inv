package com.example.warehouse.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.warehouse.Model.Warehouse;
import com.example.warehouse.Service.WarehouseService;

@RestController
@RequestMapping("/api/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService service;

    // Listar todas las ubicaciones
    @GetMapping
    public ResponseEntity<List<Warehouse>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/ubicacion/{idUbicacion}")
    public ResponseEntity<?> buscarPorIdUbicacion(@PathVariable String idUbicacion) {
        Warehouse warehouse = service.buscarPorIdUbicacion(idUbicacion);
        
        if (warehouse == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("La ubicación física '" + idUbicacion + "' no existe en los registros de la bodega.");
        }
        
        return ResponseEntity.ok(warehouse);
    }

    // Registrar ubicación
    @PostMapping
    public ResponseEntity<?> registrar(
            @RequestBody Warehouse warehouse) {
        try {
            Warehouse nuevaUbicacion =
                    service.registrar(warehouse);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(nuevaUbicacion);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // Buscar por pasillo
    @GetMapping("/pasillo/{pasillo}")
    public ResponseEntity<List<Warehouse>> buscarPorPasillo(
            @PathVariable String pasillo) {
        return ResponseEntity.ok(
                service.buscarPorPasillo(pasillo));
    }

    // Buscar por rack
    @GetMapping("/rack/{rack}")
    public ResponseEntity<List<Warehouse>> buscarPorRack(
            @PathVariable String rack) {
        return ResponseEntity.ok(
                service.buscarPorRack(rack));
    }

    // Buscar por nivel
    @GetMapping("/nivel/{nivel}")
    public ResponseEntity<List<Warehouse>> buscarPorNivel(
            @PathVariable Integer nivel) {
        return ResponseEntity.ok(
                service.buscarPorNivel(nivel));
    }

    // Eliminar ubicación
    @DeleteMapping("/{idUbicacion}")
    public ResponseEntity<?> eliminar(
            @PathVariable String idUbicacion) {
        try {
            service.eliminar(idUbicacion);
            return ResponseEntity.ok(
                    "Ubicación eliminada correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}