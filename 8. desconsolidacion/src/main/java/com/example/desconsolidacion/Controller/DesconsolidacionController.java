package com.example.desconsolidacion.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desconsolidacion.Model.Desconsolidacion;
import com.example.desconsolidacion.Service.DesconsolidacionService;

@RestController
@RequestMapping("/api/desconsolidaciones")
public class DesconsolidacionController {

    @Autowired
    private DesconsolidacionService service;

    // Listar todas las desconsolidaciones
    @GetMapping
    public ResponseEntity<List<Desconsolidacion>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{idDesconsolidacion}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long idDesconsolidacion) {
        Desconsolidacion desconsolidacion = service.buscarPorId(idDesconsolidacion);
        
        if (desconsolidacion == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("La desconsolidación con ID " + idDesconsolidacion + " no existe.");
        }
        
        return ResponseEntity.ok(desconsolidacion);
    }

    // Registrar desconsolidación
    @PostMapping
    public ResponseEntity<?> registrar(
            @RequestBody Desconsolidacion desconsolidacion) {
        try {
            Desconsolidacion nuevaDesconsolidacion =
                    service.registrar(desconsolidacion);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(nuevaDesconsolidacion);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // Buscar por factura
    @GetMapping("/factura/{numeroFactura}")
    public ResponseEntity<List<Desconsolidacion>> buscarPorFactura(
            @PathVariable String numeroFactura) {
        return ResponseEntity.ok(
                service.buscarPorFactura(numeroFactura));
    }

    // Buscar por cantidad de productos
    @GetMapping("/cantidad/{cantidadProductos}")
    public ResponseEntity<List<Desconsolidacion>>
    buscarPorCantidadProductos(
            @PathVariable Integer cantidadProductos) {
        return ResponseEntity.ok(
                service.buscarPorCantidadProductos(cantidadProductos));
    }

    // Eliminar desconsolidación
    @DeleteMapping("/{idDesconsolidacion}")
    public ResponseEntity<?> eliminar(
            @PathVariable Long idDesconsolidacion) {
        try {
            service.eliminar(idDesconsolidacion);
            return ResponseEntity.ok(
                    "Desconsolidación eliminada correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}