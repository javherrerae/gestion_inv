package com.example.warehouse.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.warehouse.Model.Warehouse;
import com.example.warehouse.Repository.WarehouseRepository;

import jakarta.transaction.Transactional;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository repository;

    // Listamos todas las ubicaciones
    public List<Warehouse> listarTodas() {
        return repository.findAll();
    }

    // Registramos una ubicación
    @Transactional
    public Warehouse registrar(Warehouse warehouse) {

        // El nivel no puede ser menor a 1

        if (warehouse.getNivel() <= 0) {
            throw new RuntimeException(
                    "El nivel debe ser mayor a 0.");
        }
        return repository.save(warehouse);
    }

    // Buscamos por pasillo
    public List<Warehouse> buscarPorPasillo(String pasillo) {
        return repository.findByPasillo(pasillo);
    }

    // Buscamos por rack
    public List<Warehouse> buscarPorRack(String rack) {
        return repository.findByRack(rack);
    }

    // Buscamos por nivel
    public List<Warehouse> buscarPorNivel(Integer nivel) {
        return repository.findByNivel(nivel);
    }

    // Eliminamos ubicación
    @Transactional
    public void eliminar(String idUbicacion) {
        repository.deleteById(idUbicacion);
    }
}