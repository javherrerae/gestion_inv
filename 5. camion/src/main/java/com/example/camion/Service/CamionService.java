package com.example.camion.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.camion.Model.Camion;
import com.example.camion.Repository.CamionRepository;

import jakarta.validation.constraints.NotNull;

@Service
public class CamionService {

    @Autowired
    private CamionRepository camionRepository;

    public List<Camion>listarTodos() {
        return camionRepository.findAll();
    }

    public Camion buscarPorPatente(String patente){
        return camionRepository.findByPatente(patente);
    }

    public Camion guardar(@NotNull Camion camion) {
        return camionRepository.save(camion);
    }

}
