package com.mercadolibre.desafio_quality.repositories;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class BairrosRepository {

    private final Map<String, Double> bairrosLista = new HashMap<String, Double>() {{
       put("Cabral", 2000.0);
       put("Água Verde", 3000.0);
       put("Batel", 3800.0);
       put("Boa Vista", 1400.0);
       put("Santa Cândida", 1000.0);
    }};



    public Optional<Double> findByName(String name){
        //TODO ignorar letrar maiusculas
        return Optional.ofNullable(bairrosLista.get(name));
    }
}
