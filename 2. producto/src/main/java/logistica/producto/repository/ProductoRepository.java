package logistica.producto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import logistica.producto.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String> {

    // Buscamos producto por Sku
    Producto findBySku(String sku);

    // Buscamos productos por categoría
    List<Producto> findByCategoria(String categoria);

    // Buscamos productos por ID desconsolidación (Para saber de donde proviene este producto)
    List<Producto> findByIdDesconsolidacion(Long idDesconsolidacion);

    // Buscamos productos por nombre
    List<Producto> findByNombreProducto(String nombreProducto);
}