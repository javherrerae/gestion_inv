package logistica.producto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import logistica.producto.client.StockFeignClient;
import logistica.producto.dto.StockDTO;
import logistica.producto.model.Producto;
import logistica.producto.repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    // Conexión con Stock
    @Autowired
    private StockFeignClient stockClient;


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

        Producto productoGuardado = repository.save(producto);

        try {    
            StockDTO nuevoStock = new StockDTO(producto.getSku(), "POR_ASIGNAR", 0);    

            stockClient.inicializarStock(nuevoStock);
            
            } catch (Exception e) {
                throw new RuntimeException
                ("Producto creado localmente, pero falló la inicialización automática de stock: " 
                + e.getMessage());
            }
        return productoGuardado;
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