package com.example.recepcion.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recepcion.Model.Recepcion;
import com.example.recepcion.Repository.RecepcionRepository;

import jakarta.transaction.Transactional;

@Service
public class RecepcionService {

    @Autowired
    private RecepcionRepository repository;

    // Listamos todas las recepciones

    public List<Recepcion> listarTodas() {
        return repository.findAll();
    }

    // Registramos una recepción

    @Transactional
    public Recepcion registrar(Recepcion recepcion) {

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
        return repository.findByNAnden(nAnden);
    }

    // Eliminamos recepcion

    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }


}
