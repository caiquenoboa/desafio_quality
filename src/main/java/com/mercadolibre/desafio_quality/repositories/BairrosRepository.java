package com.mercadolibre.desafio_quality.repositories;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

@Repository
public class BairrosRepository {

    private HashMap<String, Double> bairrosLista;

    //TODO isso aq
//    private final HashMap<String, Double> bairrosLista = new HashMap<>(
//            Map.entry("BAIRRO DOS ESTADOS", new District("BAIRRO DOS ESTADOS", 450.0)),
//            Map.entry("TORRE", new District("TORRE", 300.0)),
//            Map.entry("CABO BRANCO", new District("CABO BRANCO", 500.0)),
//            Map.entry("MANAIRA", new District("MANAIRA", 700.0)),
//            Map.entry("BANACRIOS", new District("BANACRIOS", 400.0))
//    );

    public void initBairros(){
        bairrosLista = new HashMap<>();
        bairrosLista.put("Cabral", 2000.0);
        bairrosLista.put("Água Verde", 3000.0);
        bairrosLista.put("Batel", 3800.0);
        bairrosLista.put("Boa Vista", 1400.0);
        bairrosLista.put("Santa Cândida", 1000.0);
    }

    public Optional<Double> findByName(String name){
        initBairros();
        Optional<Double> price = Optional.ofNullable(bairrosLista.get(name));
        return price;
    }
}
