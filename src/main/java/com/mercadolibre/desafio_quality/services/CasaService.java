package com.mercadolibre.desafio_quality.services;

import com.mercadolibre.desafio_quality.dtos.ComodoDTO;
import com.mercadolibre.desafio_quality.models.Comodo;
import com.mercadolibre.desafio_quality.models.Propriedade;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;

@Service
public class CasaService {

    public double calculeArea(Propriedade propriedade){
        return propriedade.getComodoList().stream().mapToDouble(obj -> calculeArea(obj))
                .reduce(0.0, ( areaTotal, area) -> areaTotal + area);
    }

    public double calculeArea(Comodo comodo){
        return comodo.getRoom_length() * comodo.getRoom_width();
    }

    public ComodoDTO calculeMaiorComodo(Propriedade propriedade){
        Comodo c = Collections.max(propriedade.getComodoList(), Comparator.comparing(comodo -> comodo.getRoom_width() * comodo.getRoom_length()));
        return new ComodoDTO(c.getRoom_name(), calculeArea(c));
    }


}
