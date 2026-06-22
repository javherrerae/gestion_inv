package com.example.Usuario.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Usuario.Model.Empleado;
import com.example.Usuario.Repository.RepoEmpleado;

import jakarta.transaction.Transactional;

@Service
public class EmpleadoService {

    @Autowired
    private RepoEmpleado repository;

    // Listamos todos los empleados
    public List<Empleado> listarTodos() {
        return repository.findAll();
    }

    // Registramos un empleado
    @Transactional
    public Empleado registrar(Empleado empleado) {
        boolean rutExiste = repository.findByRut(empleado.getRut()).isPresent();
        if (rutExiste) {
            throw new RuntimeException("El rut ya existe previamente.");
        }
        boolean correoExiste = repository.findByCorreo(empleado.getCorreo()).isPresent();
        if (correoExiste) {
            throw new RuntimeException("El correo ya existe previamente.");
        }
        return repository.save(empleado);
    }

    // Buscamos empleados activos
    public List<Empleado> listarActivos() {
        return repository.findByActivo(true);
    }

    // Buscamos por rol
    public List<Empleado> buscarPorRol(String rol) {
        return repository.findByRol(rol);
    }

    // Eliminamos empleado
    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}