package com.example.anden.Repository;

import com.example.anden.Model.Anden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AndenRepository extends JpaRepository<Anden, Integer> {
    // List<Anden> findByEstado(String estado);
}