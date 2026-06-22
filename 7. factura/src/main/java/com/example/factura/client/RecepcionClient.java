package com.example.factura.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "recepcion") // Nombre en Eureka

public interface RecepcionClient {
    @GetMapping("/api/recepciones/id/{idRecepcion}")
    ResponseEntity<?> buscarPorId(@PathVariable("idRecepcion") Long idRecepcion);
}