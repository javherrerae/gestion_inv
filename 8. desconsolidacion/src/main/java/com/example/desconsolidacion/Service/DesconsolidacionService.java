package com.example.desconsolidacion.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.desconsolidacion.Model.Desconsolidacion;
import com.example.desconsolidacion.Repository.DesconsolidacionRepository;
import jakarta.transaction.Transactional;

@Service
public class DesconsolidacionService {

    @Autowired
    private DesconsolidacionRepository repository;

    // Listamos todas las desconsolidaciones
    public List<Desconsolidacion> listarTodas() {
        return repository.findAll();
    }

    // Registramos una desconsolidación
    @Transactional
    public Desconsolidacion registrar(Desconsolidacion desconsolidacion) {
        // La cantidad de productos debe ser mayor a 0
        if (desconsolidacion.getCantidadProductos() <= 0) {
            throw new RuntimeException(
                    "La cantidad de productos debe ser mayor a 0.");
        }
        return repository.save(desconsolidacion);
    }

    // Buscamos desconsolidaciones por factura
    public List<Desconsolidacion> buscarPorFactura(Long nFactura) {
        return repository.findByNFactura(nFactura);
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