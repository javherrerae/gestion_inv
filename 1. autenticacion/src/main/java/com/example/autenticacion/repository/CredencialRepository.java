package com.example.autenticacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.autenticacion.model.Credencial;


@Repository
public interface  CredencialRepository extends JpaRepository<Credencial, Long> {

}
