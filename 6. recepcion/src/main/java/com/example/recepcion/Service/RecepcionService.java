package com.example.recepcion.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recepcion.Model.Recepcion;
import com.example.recepcion.Repository.RecepcionRepository;
import com.example.recepcion.client.AndenClient;
import com.example.recepcion.client.CamionClient;

import jakarta.transaction.Transactional;

@Service
public class RecepcionService {

    @Autowired
    private RecepcionRepository repository;
    
    @Autowired
    private CamionClient camionClient;

    @Autowired
    private AndenClient andenClient;


    public Recepcion buscarPorId(Long idRecepcion){
        return repository.findByIdRecepcion(idRecepcion);
    }
    // Listamos todas las recepciones
    public List<Recepcion> listarTodas() {
        return repository.findAll();
    }

    // Registramos una recepción

    @Transactional
    public Recepcion registrar(Recepcion recepcion) {

        // Validar la Patente del Camión
        try {
            camionClient.buscarPorPatente(recepcion.getPatente());
        } catch (feign.FeignException.NotFound e) {
            throw new RuntimeException("Operación rechazada: La patente '" + recepcion.getPatente() + "' no está registrada.");
        } catch (Exception e) {
            throw new RuntimeException("Error de comunicación con el servicio de camiones.");
        }

        // Validar el Número de Andén 
        try {
            andenClient.buscarPorNumero(recepcion.getNumeroAnden());
        } catch (feign.FeignException.NotFound e) {
            throw new RuntimeException("Operación rechazada: El andén número " + recepcion.getNumeroAnden() + " no existe.");
        } catch (Exception e) {
            throw new RuntimeException("Error de comunicación con el servicio de andenes.");
        }

        // Registramos una regla: No permitir una recepción inválida o vacía

        if (
        !recepcion.getEstado().equalsIgnoreCase("PENDIENTE")
        && !recepcion.getEstado().equalsIgnoreCase("EN_RECEPCION")
        && !recepcion.getEstado().equalsIgnoreCase("RECIBIDO")
        && !recepcion.getEstado().equalsIgnoreCase("FINALIZADO")
            ) 
        {

            throw new RuntimeException("El estado de recepción no es válido.");
        }

            return repository.save(recepcion);
    }

    // Buscamos recepciones por estado

    public List<Recepcion> buscarPorEstado(String estado) {
        return repository.findByEstado(estado);
    }

    // Buscamos recepciones por patente

    public List<Recepcion> buscarPorPatente(String patente) {
        return repository.findByPatente(patente);
    }

    // Buscamos recepciones por anden
    // Usamos Long por 

    public List<Recepcion> buscarPorAnden(Long nAnden) {
        return repository.findByNumeroAnden(nAnden);
    }

    // Eliminamos recepcion

    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }


}
