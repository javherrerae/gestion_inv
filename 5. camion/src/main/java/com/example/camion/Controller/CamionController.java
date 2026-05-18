package com.example.camion.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.camion.Model.Camion;
import com.example.camion.Service.CamionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/camiones")
public class CamionController {

    private final CamionService camionService;

    public CamionController(CamionService camionService) {
        this.camionService = camionService;
    }

    @GetMapping
    public ResponseEntity<List<Camion>> listar() {
        List<Camion> camiones = camionService.listarTodos();
        return ResponseEntity.ok(camiones);
    }

    @GetMapping("/patente/{patente}")
    public ResponseEntity<?> buscarPorPatente(@PathVariable String patente) {
        // Buscamos el camión en el servicio
        Camion camion = camionService.buscarPorPatente(patente); 
    
        if (camion == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El camión con patente '" + patente + "' no está registrado.");
            }
        
            return ResponseEntity.ok(camion);
        }

    @PostMapping
    public ResponseEntity<Camion> crear(@Valid @RequestBody Camion camion) {
        if (camion == null) {
            return ResponseEntity.badRequest().build();
        }

        Camion nuevoCamion = camionService.guardar(camion);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCamion);
    }

}
