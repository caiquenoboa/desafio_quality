package com.mercadolibre.desafio_quality.units;

import com.mercadolibre.desafio_quality.models.Comodo;
import com.mercadolibre.desafio_quality.models.Propriedade;
import com.mercadolibre.desafio_quality.services.CasaService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class CasaServiceTest {

    CasaService casaService;

    Propriedade propriedade1;
    Propriedade propriedade2;
    Propriedade propriedade3;


    void init(){

        casaService = new CasaService();

        List<Comodo> comodoList1 = new ArrayList<>();
        comodoList1.add(new Comodo("Cozinha", 4, 8));
        comodoList1.add(new Comodo("Quarto", 4, 3));
        comodoList1.add(new Comodo("Banheiro", 2, 2));
        comodoList1.add(new Comodo("Sala", 5, 4));
        propriedade1 = new Propriedade("Casa 1", "Cabral", comodoList1);

        List<Comodo> comodoList2 = new ArrayList<>();
        comodoList2.add(new Comodo("Cozinha", 2, 2));
        comodoList2.add(new Comodo("Quarto", 3, 3));
        comodoList2.add(new Comodo("Banheiro", 2, 2));
        comodoList2.add(new Comodo("Sala", 3, 4));
        propriedade2 = new Propriedade("Casa 1", "Cabral", comodoList2);

        List<Comodo> comodoList3 = new ArrayList<>();
        comodoList3.add(new Comodo("Cozinha", 4, 8));
        comodoList3.add(new Comodo("Quarto 1", 4, 3));
        comodoList3.add(new Comodo("Quarto 2", 4.5, 3));
        comodoList3.add(new Comodo("Banheiro", 2, 2));
        comodoList3.add(new Comodo("Sala", 5, 4));
        comodoList3.add(new Comodo("Sala de Jantar", 5, 4));
        propriedade3 = new Propriedade("Casa 1", "Cabral", comodoList3);

    }

    @Test
    void calculeArea1Test() {
        init();

        double d = casaService.calculeArea(propriedade1);

        assertEquals(68.0, d);
    }

    @Test
    void calculeArea2Test() {
        init();

        double d = casaService.calculeArea(propriedade2);

        assertEquals(29.0, d);
    }

    @Test
    void calculeArea3Test() {
        init();

        double d = casaService.calculeArea(propriedade3);

        assertEquals(101.5, d);
    }

    @Test
    void calculeAreaNot1Test() {
        init();

        double d = casaService.calculeArea(propriedade1);

        assertNotEquals(70.0, d);
    }

    @Test
    void calculeAreaNot2Test() {
        init();

        double d = casaService.calculeArea(propriedade2);

        assertNotEquals(30.0, d);
    }

    @Test
    void calculeAreaNot3Test() {
        init();

        double d = casaService.calculeArea(propriedade3);

        assertNotEquals(101.0, d);
    }

}