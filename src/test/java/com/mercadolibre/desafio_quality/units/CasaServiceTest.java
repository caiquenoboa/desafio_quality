package com.mercadolibre.desafio_quality.units;

import com.mercadolibre.desafio_quality.dtos.ComodoDTO;
import com.mercadolibre.desafio_quality.models.Comodo;
import com.mercadolibre.desafio_quality.models.Propriedade;
import com.mercadolibre.desafio_quality.services.CasaService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


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
        propriedade2 = new Propriedade("Casa 2", "Água Verde", comodoList2);

        List<Comodo> comodoList3 = new ArrayList<>();
        comodoList3.add(new Comodo("Cozinha", 4, 8));
        comodoList3.add(new Comodo("Quarto 1", 4, 3));
        comodoList3.add(new Comodo("Quarto 2", 4.5, 3));
        comodoList3.add(new Comodo("Banheiro", 2, 2));
        comodoList3.add(new Comodo("Sala", 5, 4));
        comodoList3.add(new Comodo("Sala de Jantar", 5, 8));
        propriedade3 = new Propriedade("Casa 3", "Santa Candida", comodoList3);

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

        assertEquals(121.5, d);
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

        assertNotEquals(121.0, d);
    }








    @Test
    void calculeMaiorComodo1Test() {
        init();
        ComodoDTO expected = new ComodoDTO("Cozinha", 32);


        ComodoDTO comodoDTO = casaService.calculeMaiorComodo(propriedade1);

        assertEquals(expected.getRoom_name(), comodoDTO.getRoom_name());
        assertEquals(expected.getRoom_area(), comodoDTO.getRoom_area());

    }

    @Test
    void calculeMaiorComodo2Test() {
        init();
        ComodoDTO expected = new ComodoDTO("Sala", 12);


        ComodoDTO comodoDTO = casaService.calculeMaiorComodo(propriedade2);

        assertEquals(expected.getRoom_name(), comodoDTO.getRoom_name());
        assertEquals(expected.getRoom_area(), comodoDTO.getRoom_area());
    }

    @Test
    void calculeMaiorComodo3Test() {
        init();
        ComodoDTO expected = new ComodoDTO("Sala de Jantar", 40);


        ComodoDTO comodoDTO = casaService.calculeMaiorComodo(propriedade3);

        assertEquals(expected.getRoom_name(), comodoDTO.getRoom_name());
        assertEquals(expected.getRoom_area(), comodoDTO.getRoom_area());
    }


    @Test
    void calculeMaiorComodoNot1Test() {
        init();
        ComodoDTO expected = new ComodoDTO("Sala", 20);


        ComodoDTO comodoDTO = casaService.calculeMaiorComodo(propriedade1);

        assertNotEquals(expected.getRoom_name(), comodoDTO.getRoom_name());
        assertNotEquals(expected.getRoom_area(), comodoDTO.getRoom_area());

    }

    @Test
    void calculeMaiorComodoNot2Test() {
        init();
        ComodoDTO expected = new ComodoDTO("Sala", 16);


        ComodoDTO comodoDTO = casaService.calculeMaiorComodo(propriedade2);

        assertEquals(expected.getRoom_name(), comodoDTO.getRoom_name());
        assertNotEquals(expected.getRoom_area(), comodoDTO.getRoom_area());
    }

    @Test
    void calculeMaiorComodoNot3Test() {
        init();
        ComodoDTO expected = new ComodoDTO("Sala", 40);


        ComodoDTO comodoDTO = casaService.calculeMaiorComodo(propriedade3);

        assertNotEquals(expected.getRoom_name(), comodoDTO.getRoom_name());
        assertEquals(expected.getRoom_area(), comodoDTO.getRoom_area());
    }

}