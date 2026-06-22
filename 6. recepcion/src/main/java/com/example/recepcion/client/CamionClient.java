package com.example.recepcion.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "camion") // Nombre en Eureka [cite: 171]
public interface CamionClient {
    @GetMapping("/api/camiones/patente/{patente}")
    ResponseEntity<?> buscarPorPatente(@PathVariable("patente") String patente);
}