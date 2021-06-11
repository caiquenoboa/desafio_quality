package com.mercadolibre.desafio_quality.services;

import com.mercadolibre.desafio_quality.dtos.ComodoDTO;
import com.mercadolibre.desafio_quality.dtos.PropriedadeDTO;
import com.mercadolibre.desafio_quality.models.Comodo;
import com.mercadolibre.desafio_quality.models.Propriedade;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CasaService {

    HashMap<String, Double> bairrosLista;

    public void initBairros(){
        bairrosLista = new HashMap<>();
        bairrosLista.put("Cabral", 2000.0);
        bairrosLista.put("Água Verde", 3000.0);
        bairrosLista.put("Batel", 3800.0);
        bairrosLista.put("Boa Vista", 1400.0);
        bairrosLista.put("Santa Cândida", 1000.0);
    }

    public PropriedadeDTO createDTO(Propriedade propriedade){
        PropriedadeDTO propriedadeDTO = new PropriedadeDTO(propriedade.getProp_name(),
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
        initBairros();
        double preco = 0;
        try{
            preco = bairrosLista.get(propriedade.getProp_district());
        }
        catch (Exception e){
            throw new RuntimeException("O bairro " + propriedade.getProp_district() + " não está cadastrado!");
        }

        return preco*calculeArea(propriedade);
    }


}
