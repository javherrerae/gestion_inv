package com.example.recepcion.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "anden") // Nombre en Eureka [cite: 172]
public interface AndenClient {
    @GetMapping("/api/andenes/{numeroAnden}")
    ResponseEntity<?> buscarPorNumero(@PathVariable("numeroAnden") Long numeroAnden);
}