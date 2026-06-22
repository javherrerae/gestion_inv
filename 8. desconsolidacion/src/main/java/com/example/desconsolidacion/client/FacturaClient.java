package com.example.desconsolidacion.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "factura")

public interface FacturaClient {
    @GetMapping("/api/facturas/{numeroFactura}")
    ResponseEntity<?> buscarPorNumeroFactura(@PathVariable("numeroFactura") String numeroFactura);
}