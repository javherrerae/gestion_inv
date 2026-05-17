package com.example.recepcion.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.recepcion.Model.Recepcion;

@Repository 
public interface RecepcionRepository extends JpaRepository<Recepcion, Long> {

    // Buscar por estado
    List<Recepcion> findByEstado(String estado);

    // Buscar por patente
    List<Recepcion> findByPatente(String patente);

    // Buscar por andén
    List<Recepcion> findByNAnden(Long nAnden);
}
