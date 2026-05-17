package logistica.producto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import logistica.producto.model.Producto;
import logistica.producto.repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    // Listamos todos los productos
    public List<Producto> listarTodos() {
        return repository.findAll();
    }

    // Registramos un producto
    @Transactional
    public Producto registrar(Producto producto) {
        boolean productoExiste = repository.findById(producto.getSku()).isPresent();
        if (productoExiste) {
            throw new RuntimeException("El producto ya existe previamente.");
        }
        // La fecha de caducidad no puede ser anterior a la fecha de fabricación
        if (producto.getFecCaducidad() != null &&
                producto.getFecCaducidad().isBefore(producto.getFecFabricacion())) {

            throw new RuntimeException("La fecha de caducidad no puede ser anterior a la fecha de fabricación.");
        }
        return repository.save(producto);
    }

    // Buscamos producto por SKU
    public Producto buscarPorSku(String sku) {
        return repository.findBySku(sku);
    }

    // Buscamos productos por categoría
    public List<Producto> buscarPorCategoria(String categoria) {
        return repository.findByCategoria(categoria);
    }

    // Buscamos productos por desconsolidación
    public List<Producto> buscarPorDesconsolidacion(Long idDesconsolidacion) {
        return repository.findByIdDesconsolidacion(idDesconsolidacion);
    }

    // Buscamos productos por nombre
    public List<Producto> buscarPorNombre(String nombreProducto) {
        return repository.findByNombreProducto(nombreProducto);
    }

    // Eliminamos producto
    @Transactional
    public void eliminar(String sku) {
        repository.deleteById(sku);
    }
}