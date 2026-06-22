package com.example.factura.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.factura.Model.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, String> {

    Factura findByNumeroFactura(String numeroFactura);

    List<Factura> findByEstado(String estado);

    List<Factura> findByProveedor(String proveedor);

    List<Factura> findByIdRecepcion(Long idRecepcion);
}
