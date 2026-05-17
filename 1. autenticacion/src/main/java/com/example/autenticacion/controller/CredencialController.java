package com.example.autenticacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.autenticacion.service.CredencialService;

@RestController
@RequestMapping("/api/credenciales")
public class CredencialController {
    @Autowired
    private CredencialService credencialService;
}
