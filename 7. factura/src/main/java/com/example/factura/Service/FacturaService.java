package com.example.factura.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.factura.Model.Factura;
import com.example.factura.Repository.FacturaRepository;
import com.example.factura.client.RecepcionClient;

import jakarta.transaction.Transactional;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository repository;

    @Autowired
    private RecepcionClient recepcionClient;

    // Listamos todas las facturas
    public List<Factura> listarTodas() {
        return repository.findAll();
    }

    public Factura buscarPorNumeroFactura(String numeroFactura){
        return repository.findByNumeroFactura(numeroFactura);
    }

    // Registramos una factura

    @Transactional
    public Factura registrar(Factura factura) {

        // Validar si el ID de Recepción ingresado es válido
        try {
            recepcionClient.buscarPorId(factura.getIdRecepcion());
        } catch (feign.FeignException.NotFound e) {
            throw new RuntimeException("Operación rechazada: La recepción con ID " + factura.getIdRecepcion() + " no existe.");
        } catch (Exception e) {
            throw new RuntimeException("Error de comunicación inter-servicio con Recepciones.");
        }

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
