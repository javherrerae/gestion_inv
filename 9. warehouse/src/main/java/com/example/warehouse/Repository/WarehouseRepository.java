package com.example.warehouse.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.warehouse.Model.Warehouse;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, String> {

    // Buscar por pasillo
    List<Warehouse> findByPasillo(String pasillo);

    // Buscar por rack
    List<Warehouse> findByRack(String rack);

    // Buscar por nivel
    List<Warehouse> findByNivel(Integer nivel);
}