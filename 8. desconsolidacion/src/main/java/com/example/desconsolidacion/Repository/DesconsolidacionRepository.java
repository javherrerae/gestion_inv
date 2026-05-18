package com.example.desconsolidacion.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.desconsolidacion.Model.Desconsolidacion;

@Repository
public interface DesconsolidacionRepository extends JpaRepository<Desconsolidacion, Long> {

    Desconsolidacion findByIdDesconsolidacion(Long idDesconsolidacion);

    // Buscar por número de factura
    List<Desconsolidacion> findByNumeroFactura(String numeroFactura);

    // Buscar por cantidad de productos
    List<Desconsolidacion> findByCantidadProductos(Integer cantidadProductos);
}