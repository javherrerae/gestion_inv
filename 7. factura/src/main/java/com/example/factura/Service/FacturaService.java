package com.example.factura.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.factura.Model.Factura;
import com.example.factura.Repository.FacturaRepository;

import jakarta.transaction.Transactional;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository repository;

    // Listamos todas las facturas

    public List<Factura> listarTodas() {
        return repository.findAll();
    }

    // Registramos una factura

    @Transactional
    public Factura registrar(Factura factura) {

        // Solo se permiten los siguientes estados de factura: REGISTRADA, EN_REVISION, VALIDADA, RECHAZADA

        if (
                !factura.getEstado().equalsIgnoreCase("REGISTRADA")
                && !factura.getEstado().equalsIgnoreCase("EN_REVISION")
                && !factura.getEstado().equalsIgnoreCase("VALIDADA")
                && !factura.getEstado().equalsIgnoreCase("RECHAZADA")
        ) {
            throw new RuntimeException("El estado de factura no es válido.");
        }

        return repository.save(factura);
    }

    // Buscamos facturas por estado
    public List<Factura> buscarPorEstado(String estado) {
        return repository.findByEstado(estado);
    }

    // Buscamos facturas por proveedor
    public List<Factura> buscarPorProveedor(String proveedor) {
        return repository.findByProveedor(proveedor);
    }

    // Buscamos facturas por recepción
    public List<Factura> buscarPorRecepcion(Long idRecepcion) {
        return repository.findByIdRecepcion(idRecepcion);
    }

    // Eliminamos factura
    @Transactional
    public void eliminar (String nFactura) {
        repository.deleteById(nFactura);
    }


}
