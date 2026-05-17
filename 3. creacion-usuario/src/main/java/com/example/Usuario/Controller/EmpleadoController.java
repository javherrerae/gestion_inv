package com.example.Usuario.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Usuario.Model.Empleado;
import com.example.Usuario.Service.EmpleadoService;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService service;

    // Listar todos los empleados
    @GetMapping
    public ResponseEntity<List<Empleado>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    // Registrar empleado
    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody Empleado empleado) {
        try {
            Empleado nuevoEmpleado = service.registrar(empleado);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEmpleado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // Listar empleados activos
    @GetMapping("/activos")
    public ResponseEntity<List<Empleado>> listarActivos() {
        return ResponseEntity.ok(service.listarActivos());
    }

    // Buscar empleados por rol
    @GetMapping("/rol/{rol}")
    public ResponseEntity<List<Empleado>> buscarPorRol(@PathVariable String rol) {
        return ResponseEntity.ok(service.buscarPorRol(rol));
    }

    // Eliminar empleado
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            service.eliminar(id);
            return ResponseEntity.ok("Empleado eliminado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}