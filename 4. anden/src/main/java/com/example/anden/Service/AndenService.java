package com.example.anden.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.example.anden.Model.Anden;
import com.example.anden.Repository.AndenRepository;

@Service
public class AndenService {

    @Autowired
    private AndenRepository andenRepository;

    public List<Anden> listartodos() {
        return andenRepository.findAll();
    }

    public Anden buscarPorNumero(Long anden){
        return andenRepository.findByNumeroanden(anden);
    }

    public Anden guardar(@NonNull Anden anden) {
        return andenRepository.save(anden);
    }

}
