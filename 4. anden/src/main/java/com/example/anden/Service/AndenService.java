package com.example.anden.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import com.example.anden.Model.Anden;
import com.example.anden.Repository.AndenRepository;

public class AndenService {

    @Autowired
    private AndenRepository andenRepository;

    public List<Anden> listartodos() {
        return andenRepository.findAll();
    }

    public Anden guardar(@NonNull Anden anden) {
        return andenRepository.save(anden);
    }

}
