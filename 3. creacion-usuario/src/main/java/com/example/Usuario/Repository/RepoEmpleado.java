package com.example.Usuario.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Usuario.Model.Empleado;

@Repository
public interface RepoEmpleado extends JpaRepository<Empleado, Long> {

    // Buscar por correo
    Optional<Empleado> findByCorreo(String correo);

    // Buscar por rut
    Optional<Empleado> findByRut(String rut);

    // Buscar usuarios activos
    List<Empleado> findByActivo(Boolean activo);

    // Buscar por rol
    List<Empleado> findByRol(String rol);
}