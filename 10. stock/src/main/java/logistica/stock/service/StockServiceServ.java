package logistica.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import logistica.stock.client.ProductClient;
import logistica.stock.model.Stock;
import logistica.stock.repository.StockRepository;

@Service
public class StockServiceServ {

    @Autowired
    private StockRepository stockRepository;

    // Conexión con Producto
    @Autowired
    private ProductClient productoClient;

    // 1. Listar todo el stock disponible
    public List<Stock> listarTodos() {
        return stockRepository.findAll();
    }

// 2. Registrar o incrementar Stock
    @Transactional
    public Stock registrarOActualizar(Stock stock) {
        try {
            // Verificar si el producto existe
            productoClient.buscarPorSku(stock.getSku());
            
        } catch (feign.FeignException e) {
            // Feign intercepta las respuestas de error (4xx y 5xx) del microservicio de productos
            if (e.status() == 404) {
                throw new RuntimeException("El SKU '" + stock.getSku() + "' no existe en el catálogo de productos.");
            }
            throw new RuntimeException("Error en el microservicio de productos: " + e.contentUTF8());
            
        } catch (Exception e) {
            // Captura errores desconocidos
            throw new RuntimeException("Error de comunicación inter-servicio: No se pudo conectar con el catálogo. "
            + e.getMessage());
        }

        // Evitar que ingresen directo valores negativos por Postman
        if (stock.getCantDisponibles() != null && stock.getCantDisponibles() < 0) {
            throw new RuntimeException("La cantidad inicial de stock no puede ser un número negativo.");
        }

        // Si el producto ya existe en esa ubicación, se suma, si no, se crea
        Stock stockExistente = stockRepository.findBySkuAndIdUbicacion(stock.getSku(), stock.getIdUbicacion());

        if (stockExistente != null) {
            stockExistente.setCantDisponibles(stockExistente.getCantDisponibles() + stock.getCantDisponibles());
            return stockRepository.save(stockExistente);
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