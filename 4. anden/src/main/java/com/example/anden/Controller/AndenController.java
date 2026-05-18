package com.example.anden.Controller;

import org.springframework.http.HttpStatus;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anden.Model.Anden;
import com.example.anden.Service.AndenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/andenes")
public class AndenController {

    private final AndenService andenService;

    public AndenController(AndenService andenService) {
        this.andenService = andenService;
    }

    @GetMapping
    public ResponseEntity<List<Anden>> listar() {
        List<Anden> andenes = andenService.listartodos();
        return ResponseEntity.ok(andenes);      // Devuelve 200 OK
    }

    @GetMapping("/{nAnden}")
    public ResponseEntity<?> buscarPorNumero(@PathVariable Long nAnden) {
        Anden anden = andenService.buscarPorNumero(nAnden);
        
        if (anden == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El andén número " + nAnden + " no existe en el sistema.");
        }
        
        return ResponseEntity.ok(anden);
    }

    @PostMapping
    public ResponseEntity<Anden> crear(@Valid @RequestBody Anden anden) {
        if (anden == null) {
            return ResponseEntity.badRequest().build();
            }
        Anden nuevoAnden = andenService.guardar(anden);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoAnden); // Devuelve 201
}


}
