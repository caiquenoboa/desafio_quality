package com.mercadolibre.desafio_quality.services;

import com.mercadolibre.desafio_quality.dtos.ComodoDTO;
import com.mercadolibre.desafio_quality.dtos.PropriedadeDTO;
import com.mercadolibre.desafio_quality.models.Comodo;
import com.mercadolibre.desafio_quality.models.Propriedade;
import com.mercadolibre.desafio_quality.repositories.BairrosRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CasaService {

    private final BairrosRepository bairrosRepository;

    public CasaService(BairrosRepository bairrosRepository) {
        this.bairrosRepository = bairrosRepository;
    }

    //TODO ter um repository e ter um ComodoService
    public PropriedadeDTO createDTO(Propriedade propriedade){
        PropriedadeDTO propriedadeDTO = new PropriedadeDTO(
                propriedade.getProp_name(),
                propriedade.getProp_district(),
                createListComodoDTO(propriedade.getRooms()),
                calculeArea(propriedade),
                calculePrice(propriedade),
                calculeMaiorComodo(propriedade)
        );

        return propriedadeDTO;
    }

    public List<ComodoDTO> createListComodoDTO(List<Comodo> comodoList){
        List<ComodoDTO> comodoDTOList = new ArrayList<>();
        for (Comodo comodo : comodoList){
            comodoDTOList.add(new ComodoDTO(comodo.getRoom_name(), calculeArea(comodo)));
        }
        return comodoDTOList;
    }

    public double calculeArea(Propriedade propriedade){
        return propriedade.getRooms().stream().mapToDouble(obj -> calculeArea(obj))
                .reduce(0.0, ( areaTotal, area) -> areaTotal + area);
    }

    public double calculeArea(Comodo comodo){
        return comodo.getRoom_length() * comodo.getRoom_width();
    }

    public ComodoDTO calculeMaiorComodo(Propriedade propriedade){
        Comodo c = Collections.max(propriedade.getRooms(), Comparator.comparing(comodo -> comodo.getRoom_width() * comodo.getRoom_length()));
        return new ComodoDTO(c.getRoom_name(), calculeArea(c));
    }

    public double calculePrice(Propriedade propriedade){


        double preco = bairrosRepository.findByName(propriedade.getProp_district())
                .orElseThrow(() -> new RuntimeException("O bairro " + propriedade.getProp_district() + " não está cadastrado!"));;


        return preco*calculeArea(propriedade);
    }


}
