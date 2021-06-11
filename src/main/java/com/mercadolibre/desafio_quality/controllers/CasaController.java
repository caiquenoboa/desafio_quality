package com.mercadolibre.desafio_quality.controllers;

import com.mercadolibre.desafio_quality.dtos.PropriedadeDTO;
import com.mercadolibre.desafio_quality.models.Propriedade;
import com.mercadolibre.desafio_quality.services.CasaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CasaController {

    CasaService casaService;

    public CasaController(CasaService casaService) {
        this.casaService = casaService;
    }

    @PostMapping("/propriedades")
    public ResponseEntity<PropriedadeDTO> analyzeNotes(@RequestBody @Valid Propriedade propriedade){
        PropriedadeDTO propriedadeDTO = casaService.createDTO(propriedade);
        return new ResponseEntity<>(propriedadeDTO, HttpStatus.CREATED);
    }
}
