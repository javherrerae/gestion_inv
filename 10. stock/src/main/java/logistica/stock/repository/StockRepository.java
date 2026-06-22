package logistica.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import logistica.stock.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    //Buscar stock por un producto específico
    List<Stock> findBySku(String sku);

    //Buscar todo el stock que se encuentra en una ubicación específica del Warehouse
    List<Stock> findByIdUbicacion(String idUbicacion);

    //Buscar la combinación exacta de Producto y Ubicación
    Stock findBySkuAndIdUbicacion(String sku, String idUbicacion);
}