package com.example.factura.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.factura.Model.Factura;
import com.example.factura.Service.FacturaService;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    @Autowired
    private FacturaService service;

    // Listar todas las facturas
    @GetMapping
    public ResponseEntity<List<Factura>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{numeroFactura}")
    public ResponseEntity<?> buscarPorNumeroFactura(@PathVariable String numeroFactura) {
        Factura factura = service.buscarPorNumeroFactura(numeroFactura);
        
        if (factura == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El número de factura '" + numeroFactura + "' no existe en los registros.");
        }
        
        return ResponseEntity.ok(factura);
    }

    // Registrar factura
    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody Factura factura) {

        try {
            Factura nuevaFactura = service.registrar(factura);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(nuevaFactura);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // Buscar facturas por estado
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Factura>> buscarPorEstado(
            @PathVariable String estado) {

        return ResponseEntity.ok(service.buscarPorEstado(estado));
    }

    // Buscar facturas por proveedor
    @GetMapping("/proveedor/{proveedor}")
    public ResponseEntity<List<Factura>> buscarPorProveedor(
            @PathVariable String proveedor) {

        return ResponseEntity.ok(service.buscarPorProveedor(proveedor));
    }

    // Buscar facturas por recepción
    @GetMapping("/recepcion/{idRecepcion}")
    public ResponseEntity<List<Factura>> buscarPorRecepcion(
            @PathVariable Long idRecepcion) {
        return ResponseEntity.ok(service.buscarPorRecepcion(idRecepcion));
    }

    // Eliminar factura
    @DeleteMapping("/{nFactura}")
    public ResponseEntity<?> eliminar(@PathVariable String numeroFactura) {
        try {
            service.eliminar(numeroFactura);
            return ResponseEntity.ok("Factura eliminada correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}