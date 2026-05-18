package com.example.recepcion.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.recepcion.Model.Recepcion;
import com.example.recepcion.Service.RecepcionService;

@RestController
@RequestMapping("/api/recepciones")
public class RecepcionController {

    @Autowired
    private RecepcionService service;

    // Listamos todas las recepciones

    @GetMapping
    public ResponseEntity<List<Recepcion>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas()); 
    }

    @GetMapping("/id/{idRecepcion}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long idRecepcion) {
        Recepcion recepcion = service.buscarPorId(idRecepcion);
        
        if (recepcion == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró ningún registro de recepción con el ID: " + idRecepcion);
        }
        
        return ResponseEntity.ok(recepcion);
    }

    // Registramos recepción

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody Recepcion recepcion) {
        try {
            Recepcion nuevaRecepcion = service.registrar(recepcion);

            return ResponseEntity.status(HttpStatus.CREATED)
                                .body(nuevaRecepcion);
        } catch (RuntimeException e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(e.getMessage());
        }
    }

    // Buscar recepciones por estado

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Recepcion>> buscarPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(service.buscarPorEstado(estado));
    }

    // Buscar recepciones por patente

    @GetMapping("/patente/{patente}")
    public ResponseEntity<List<Recepcion>> buscarPorPatente (@PathVariable String patente) {
        return ResponseEntity.ok(service.buscarPorPatente(patente));
    }

    // Buscar recepciones por andén

    @GetMapping("/anden/{nAnden}")
    public ResponseEntity<List<Recepcion>> buscarPorAnden(@PathVariable Long nAnden) {
        return ResponseEntity.ok(service.buscarPorAnden(nAnden));
    }

    // Eliminar recepcion

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            service.eliminar(id);

            return ResponseEntity.ok("Recepcion eliminada correctamente");
            // Usamos el RuntimeException para atrapar el error y mandarlo con un 400 BAD REQUEST
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(e.getMessage());

        }
    }   

}
