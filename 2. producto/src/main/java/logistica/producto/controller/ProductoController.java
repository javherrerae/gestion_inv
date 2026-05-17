package logistica.producto.controller;

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

import logistica.producto.model.Producto;
import logistica.producto.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductoService service;

    // Listar todos los productos
    @GetMapping
    public ResponseEntity<List<Producto>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/sku/{sku}")
    public ResponseEntity<?> buscarPorSku(@PathVariable String sku) {
        Producto producto = service.buscarPorSku(sku);
        if (producto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El producto con SKU " + sku + " no existe.");
        }
        return ResponseEntity.ok(producto);
    }

    // Registrar producto
    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody Producto producto) {
        try {
            Producto nuevoProducto = service.registrar(producto);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(nuevoProducto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // Buscar productos por categoría
    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Producto>> buscarPorCategoria(
            @PathVariable String categoria) {
        return ResponseEntity.ok(service.buscarPorCategoria(categoria));
    }

    // Buscar productos por desconsolidación
    @GetMapping("/desconsolidacion/{idDesconsolidacion}")
    public ResponseEntity<List<Producto>> buscarPorDesconsolidacion(
            @PathVariable Long idDesconsolidacion) {
        return ResponseEntity.ok(
                service.buscarPorDesconsolidacion(idDesconsolidacion));
    }

    // Buscar productos por nombre
    @GetMapping("/nombre/{nombreProducto}")
    public ResponseEntity<List<Producto>> buscarPorNombre(
            @PathVariable String nombreProducto) {
        return ResponseEntity.ok(
                service.buscarPorNombre(nombreProducto));
    }

    // Eliminar producto
    @DeleteMapping("/{sku}")
    public ResponseEntity<?> eliminar(@PathVariable String sku) {
        try {
            service.eliminar(sku);
            return ResponseEntity.ok("Producto eliminado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}