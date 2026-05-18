package com.example.camion.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.camion.Model.Camion;

@Repository
public interface CamionRepository extends JpaRepository<Camion, String> {
    Camion findByPatente(String patente);
}
