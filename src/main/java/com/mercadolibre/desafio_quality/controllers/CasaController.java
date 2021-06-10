package com.mercadolibre.desafio_quality.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CasaController {

    @GetMapping
    public String getComodo(){
        return "  vazio  ";
    }
}
