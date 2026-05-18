package com.example.desconsolidacion.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.desconsolidacion.Model.Desconsolidacion;
import com.example.desconsolidacion.Repository.DesconsolidacionRepository;
import com.example.desconsolidacion.client.FacturaClient;

import jakarta.transaction.Transactional;

@Service
public class DesconsolidacionService {

    @Autowired
    private DesconsolidacionRepository repository;

    @Autowired
    private FacturaClient facturaClient;

    // Listamos todas las desconsolidaciones
    public List<Desconsolidacion> listarTodas() {
        return repository.findAll();
    }

    public Desconsolidacion buscarPorId(Long idDesconsolidacion){
        return repository.findByIdDesconsolidacion(idDesconsolidacion);
    }

    // Registramos una desconsolidación
    @Transactional
    public Desconsolidacion registrar(Desconsolidacion desconsolidacion) {
        // Validar el nFactura de forma remota
        try {
            facturaClient.buscarPorNumeroFactura(desconsolidacion.getNumeroFactura());
        } catch (feign.FeignException.NotFound e) {
            throw new RuntimeException("Operación rechazada: El número de factura '" + desconsolidacion.getNumeroFactura() + "' no está registrado."); // [cite: 217]
        } catch (Exception e) {
            throw new RuntimeException("Error de comunicación inter-servicio con Facturas.");
        }
        // La cantidad de productos debe ser mayor a 0
        if (desconsolidacion.getCantidadProductos() <= 0) {
            throw new RuntimeException(
                    "La cantidad de productos debe ser mayor a 0.");
        }
        return repository.save(desconsolidacion);
    }

    // Buscamos desconsolidaciones por factura
    public List<Desconsolidacion> buscarPorFactura(String numeroFactura) {
        return repository.findByNumeroFactura(numeroFactura);
    }

    // Buscamos por cantidad de productos
    public List<Desconsolidacion> buscarPorCantidadProductos(
            Integer cantidadProductos) {
        return repository.findByCantidadProductos(cantidadProductos);
    }

    // Eliminar una Desconsolidacion
    @Transactional
    public void eliminar(Long idDesconsolidacion) {
        repository.deleteById(idDesconsolidacion);
    }
}