package logistica.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import logistica.stock.client.StockClient;
import logistica.stock.model.Stock;
import logistica.stock.repository.StockRepository;

@Service
public class StockServiceServ {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private StockClient productoClient;

    // 1. Listar todo el stock disponible
    public List<Stock> listarTodos() {
        return stockRepository.findAll();
    }

    // 2. Registrar o incrementar Stock
    @Transactional
    public Stock registrarOActualizar(Stock stock) {
        // Validar de forma sincrónica si el SKU existe en el otro microservicio
        try {
            var response = productoClient.buscarPorSku(stock.getSku());
            if (response == null || response.getStatusCode().isError()) {
                throw new RuntimeException("El SKU '" + stock.getSku() + "' no existe en el catálogo de productos.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error de comunicación inter-servicio: No se pudo validar el producto. " + e.getMessage());
        }

        // Evitar que ingresen directo valores negativos por Postman
        if (stock.getCantDisponibles() != null && stock.getCantDisponibles() < 0) {
            throw new RuntimeException("La cantidad inicial de stock no puede ser un número negativo.");
        }

        // Si el producto ya existe en esa ubicación, se suma, si no, se crea
        Stock stockExistente = stockRepository.findBySkuAndIdUbicacion(stock.getSku(), stock.getIdUbicacion());

        if (stockExistente != null) {
            Stock stockActualizar = stockExistente;
            stockActualizar.setCantDisponibles(stockActualizar.getCantDisponibles() + stock.getCantDisponibles());
            return stockRepository.save(stockActualizar);
        } else {
            return stockRepository.save(stock);
        }
    }

    // Buscar stock por SKU de un producto
    public List<Stock> buscarPorSku(String sku) {
        return stockRepository.findBySku(sku);
    }

    // Buscar todo el stock almacenado en una ubicación específica (ej: Pasillo/Rack)
    public List<Stock> buscarPorUbicacion(String idUbicacion) {
        return stockRepository.findByIdUbicacion(idUbicacion);
    }

    // Descontar Stock | Pendiente!
    /*@Transactional
    public Stock descontarStock(String sku, String idUbicacion, Integer cantidadADescontar) {
        Stock stock = stockRepository.findBySkuAndIdUbicacion(sku, idUbicacion)
                .orElseThrow(() -> new RuntimeException("No se encontró registro de stock para el SKU en la ubicación indicada."));

        // Regla de Negocio 4: Romper el flujo si no hay suficientes existencias físicas
        if (stock.getCant_disponibles() < cantidadADescontar) {
            throw new RuntimeException("Operación rechazada: Stock insuficiente. Unidades disponibles: " + stock.getCant_disponibles());
        }

        stock.setCant_disponibles(stock.getCant_disponibles() - cantidadADescontar);
        return stockRepository.save(stock);
    }
    */

}