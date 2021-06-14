package com.mercadolibre.desafio_quality.units;

import com.mercadolibre.desafio_quality.dtos.ComodoDTO;
import com.mercadolibre.desafio_quality.models.Comodo;
import com.mercadolibre.desafio_quality.models.Propriedade;
import com.mercadolibre.desafio_quality.repositories.BairrosRepository;
import com.mercadolibre.desafio_quality.services.CasaService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CasaServiceUnitTest {
    @Mock
    private BairrosRepository bairrosRepository;

    @InjectMocks
    private CasaService casaService;

    private static Propriedade propriedade1;
    private static Propriedade propriedade2;
    private static Propriedade propriedade3;


    @BeforeAll
    static void init(){

        propriedade1 = new Propriedade("Casa 1", "Cabral",
                Arrays.asList(
                    new Comodo("Cozinha", 4.0, 8.0),
                    new Comodo("Quarto", 4.0, 3.0),
                    new Comodo("Banheiro", 2.0, 2.0),
                    new Comodo("Sala", 5.0, 4.0)
                )
        );

        List<Comodo> comodoList2 = new ArrayList<>();
        comodoList2.add(new Comodo("Cozinha", 2.0, 2.0));
        comodoList2.add(new Comodo("Quarto", 3.0, 3.0));
        comodoList2.add(new Comodo("Banheiro", 2.0, 2.0));
        comodoList2.add(new Comodo("Sala", 3.0, 4.0));
        propriedade2 = new Propriedade("Casa 2", "Água Verde", comodoList2);

        List<Comodo> comodoList3 = new ArrayList<>();
        comodoList3.add(new Comodo("Cozinha", 4.0, 8.0));
        comodoList3.add(new Comodo("Quarto 1", 4.0, 3.0));
        comodoList3.add(new Comodo("Quarto 2", 4.5, 3.0));
        comodoList3.add(new Comodo("Banheiro", 2.0, 2.0));
        comodoList3.add(new Comodo("Sala", 5.0, 4.0));
        comodoList3.add(new Comodo("Sala de Jantar", 5.0, 8.0));
        propriedade3 = new Propriedade("Casa 3", "Santa Cândida", comodoList3);

    }

    @Test
    void calculeArea1Test() {
        double d = casaService.calculeArea(propriedade1);

        assertEquals(68.0, d);
    }
    @Test
    void calculeArea2Test() {

        double d = casaService.calculeArea(propriedade2);

        assertEquals(29.0, d);
    }
    @Test
    void calculeArea3Test() {

        double d = casaService.calculeArea(propriedade3);

        assertEquals(121.5, d);
    }

    @Test
    void calculeAreaNot1Test() {

        double d = casaService.calculeArea(propriedade1);

        assertNotEquals(70.0, d);
    }
    @Test
    void calculeAreaNot2Test() {

        double d = casaService.calculeArea(propriedade2);

        assertNotEquals(30.0, d);
    }
    @Test
    void calculeAreaNot3Test() {

        double d = casaService.calculeArea(propriedade3);

        assertNotEquals(121.0, d);
    }


    @Test
    void calculePrice1Test() {
        when(bairrosRepository.findByName(any())).thenReturn(java.util.Optional.of(2000.0));

        double d = casaService.calculePrice(propriedade1);

        assertEquals(136000.0, d);
    }
    @Test
    void calculePrice2Test() {
        when(bairrosRepository.findByName(any())).thenReturn(java.util.Optional.of(3000.0));

        double d = casaService.calculePrice(propriedade2);

        assertEquals(87000.0, d);
    }
    @Test
    void calculePrice3Test() {
        when(bairrosRepository.findByName(any())).thenReturn(java.util.Optional.of(1000.0));

        double d = casaService.calculePrice(propriedade3);

        assertEquals(121500.0, d);
    }

    @Test
    void calculePriceNot1Test() {
        when(bairrosRepository.findByName(any())).thenReturn(java.util.Optional.of(2000.0));

        double d = casaService.calculePrice(propriedade1);

        assertNotEquals(136500.0, d);
    }
    @Test
    void calculePriceNot2Test() {
        when(bairrosRepository.findByName(any())).thenReturn(java.util.Optional.of(3000.0));

        double d = casaService.calculePrice(propriedade2);

        assertNotEquals(87500.0, d);
    }
    @Test
    void calculePriceNot3Test() {
        when(bairrosRepository.findByName(any())).thenReturn(java.util.Optional.of(1000.0));

        double d = casaService.calculePrice(propriedade3);

        assertNotEquals(121000.0, d);
    }
    @Test
    void calculePriceNullTest() {
        when(bairrosRepository.findByName(any())).thenReturn(java.util.Optional.empty());
        assertThrows(RuntimeException.class, () -> casaService.calculePrice(propriedade2));
    }


    @Test
    void calculeMaiorComodo1Test() {
        ComodoDTO expected = new ComodoDTO("Cozinha", 32);


        ComodoDTO comodoDTO = casaService.calculeMaiorComodo(propriedade1.getRooms());

        assertEquals(expected.toString(), comodoDTO.toString());

    }
    @Test
    void calculeMaiorComodo2Test() {
        ComodoDTO expected = new ComodoDTO("Sala", 12);


        ComodoDTO comodoDTO = casaService.calculeMaiorComodo(propriedade2.getRooms());

        assertEquals(expected.toString(), comodoDTO.toString());
    }
    @Test
    void calculeMaiorComodo3Test() {
        ComodoDTO expected = new ComodoDTO("Sala de Jantar", 40);


        ComodoDTO comodoDTO = casaService.calculeMaiorComodo(propriedade3.getRooms());

        assertEquals(expected.toString(), comodoDTO.toString());
    }

    @Test
    void calculeMaiorComodoNot1Test() {
        ComodoDTO expected = new ComodoDTO("Sala", 20);


        ComodoDTO comodoDTO = casaService.calculeMaiorComodo(propriedade1.getRooms());

        assertNotEquals(expected.getRoom_name(), comodoDTO.getRoom_name());
        assertNotEquals(expected.getRoom_area(), comodoDTO.getRoom_area());

    }
    @Test
    void calculeMaiorComodoNot2Test() {
        ComodoDTO expected = new ComodoDTO("Sala", 16);


        ComodoDTO comodoDTO = casaService.calculeMaiorComodo(propriedade2.getRooms());

        assertEquals(expected.getRoom_name(), comodoDTO.getRoom_name());
        assertNotEquals(expected.getRoom_area(), comodoDTO.getRoom_area());
    }
    @Test
    void calculeMaiorComodoNot3Test() {
        ComodoDTO expected = new ComodoDTO("Sala", 40);


        ComodoDTO comodoDTO = casaService.calculeMaiorComodo(propriedade3.getRooms());

        assertNotEquals(expected.getRoom_name(), comodoDTO.getRoom_name());
        assertEquals(expected.getRoom_area(), comodoDTO.getRoom_area());
    }


    @Test
    void calculeCreateComodoDTO1Test() {

        List<ComodoDTO> comodoDTOExpected = new ArrayList<>();
        comodoDTOExpected.add(new ComodoDTO("Cozinha", 32));
        comodoDTOExpected.add(new ComodoDTO("Quarto", 12));
        comodoDTOExpected.add(new ComodoDTO("Banheiro", 4));
        comodoDTOExpected.add(new ComodoDTO("Sala", 20));


        List<ComodoDTO> comodoDTOList = casaService.createListComodoDTO(propriedade1.getRooms());


        assertEquals(comodoDTOExpected.toString(), comodoDTOList.toString());
    }
    @Test
    void calculeCreateComodoDTO2Test() {

        List<ComodoDTO> comodoDTOExpected = new ArrayList<>();
        comodoDTOExpected.add(new ComodoDTO("Cozinha", 4));
        comodoDTOExpected.add(new ComodoDTO("Quarto", 9));
        comodoDTOExpected.add(new ComodoDTO("Banheiro", 4));
        comodoDTOExpected.add(new ComodoDTO("Sala", 12));


        List<ComodoDTO> comodoDTOList = casaService.createListComodoDTO(propriedade2.getRooms());

        assertEquals(comodoDTOExpected.toString(), comodoDTOList.toString());

    }
    @Test
    void calculeCreateComodoDTO3Test() {

        List<ComodoDTO> comodoDTOExpected = new ArrayList<>();
        comodoDTOExpected.add(new ComodoDTO("Cozinha", 32));
        comodoDTOExpected.add(new ComodoDTO("Quarto 1", 12));
        comodoDTOExpected.add(new ComodoDTO("Quarto 2", 13.5));
        comodoDTOExpected.add(new ComodoDTO("Banheiro", 4));
        comodoDTOExpected.add(new ComodoDTO("Sala", 20));
        comodoDTOExpected.add(new ComodoDTO("Sala de Jantar", 40));


        List<ComodoDTO> comodoDTOList = casaService.createListComodoDTO(propriedade3.getRooms());

        assertEquals(comodoDTOExpected.toString(), comodoDTOList.toString());

    }

    @Test
    void calculeCreateComodoDTONot1Test() {

        List<ComodoDTO> comodoDTOExpected = new ArrayList<>();
        comodoDTOExpected.add(new ComodoDTO("Cozinha", 40));
        comodoDTOExpected.add(new ComodoDTO("Quarto", 14));
        comodoDTOExpected.add(new ComodoDTO("Banheiro", 6));
        comodoDTOExpected.add(new ComodoDTO("Sala", 21));


        List<ComodoDTO> comodoDTOList = casaService.createListComodoDTO(propriedade1.getRooms());


        for (int i = 0; i < comodoDTOExpected.size(); i++){
            assertEquals(comodoDTOExpected.get(i).getRoom_name(), comodoDTOList.get(i).getRoom_name());
            assertNotEquals(comodoDTOExpected.get(i).getRoom_area(), comodoDTOList.get(i).getRoom_area());
        }
    }
    @Test
    void calculeCreateComodoDTONot2Test() {

        List<ComodoDTO> comodoDTOExpected = new ArrayList<>();
        comodoDTOExpected.add(new ComodoDTO("Quarto", 4));
        comodoDTOExpected.add(new ComodoDTO("Quarto 1", 9));
        comodoDTOExpected.add(new ComodoDTO("Cozinha", 4));
        comodoDTOExpected.add(new ComodoDTO("Sala de Jantar", 12));


        List<ComodoDTO> comodoDTOList = casaService.createListComodoDTO(propriedade2.getRooms());


        for (int i = 0; i < comodoDTOExpected.size(); i++){
            assertNotEquals(comodoDTOExpected.get(i).getRoom_name(), comodoDTOList.get(i).getRoom_name());
            assertEquals(comodoDTOExpected.get(i).getRoom_area(), comodoDTOList.get(i).getRoom_area());
        }
    }
    @Test
    void calculeCreateComodoDTONot3Test() {

        List<ComodoDTO> comodoDTOExpected = new ArrayList<>();
        comodoDTOExpected.add(new ComodoDTO("Cozinha", 32));
        comodoDTOExpected.add(new ComodoDTO("Quarto 2", 12));
        comodoDTOExpected.add(new ComodoDTO("Quarto 1", 13.5));
        comodoDTOExpected.add(new ComodoDTO("Banheiro", 4));
        comodoDTOExpected.add(new ComodoDTO("Sala", 20));
        comodoDTOExpected.add(new ComodoDTO("Sala de Jantar", 40));


        List<ComodoDTO> comodoDTOList = casaService.createListComodoDTO(propriedade3.getRooms());


        for (int i = 0; i < comodoDTOExpected.size(); i++){
            if(i == 1 || i ==2){
                assertNotEquals(comodoDTOExpected.get(i).getRoom_name(), comodoDTOList.get(i).getRoom_name());
                assertEquals(comodoDTOExpected.get(i).getRoom_area(), comodoDTOList.get(i).getRoom_area());
            }
            else{
                assertEquals(comodoDTOExpected.get(i).getRoom_name(), comodoDTOList.get(i).getRoom_name());
                assertEquals(comodoDTOExpected.get(i).getRoom_area(), comodoDTOList.get(i).getRoom_area());
            }

        }

    }


}

