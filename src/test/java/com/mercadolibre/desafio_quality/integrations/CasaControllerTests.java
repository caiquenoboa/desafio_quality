package com.mercadolibre.desafio_quality.integrations;

import com.mercadolibre.desafio_quality.models.Comodo;
import com.mercadolibre.desafio_quality.models.Propriedade;
import com.mercadolibre.desafio_quality.services.CasaService;
import com.mercadolibre.desafio_quality.utils.ObjectToJson;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CasaControllerTests {

    @Autowired
    private MockMvc mockMvc;

    Propriedade propriedade1;
    Propriedade propriedade2;
    Propriedade propriedade3;

    public void init(){

        List<Comodo> comodoList1 = new ArrayList<>();
        comodoList1.add(new Comodo("Cozinha", 4.0, 8.0));
        comodoList1.add(new Comodo("Quarto", 4.0, 3.0));
        comodoList1.add(new Comodo("Banheiro", 2.0, 2.0));
        comodoList1.add(new Comodo("Sala", 5.0, 4.0));
        propriedade1 = new Propriedade("Casa 1", "Cabral", comodoList1);

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
    public void testEndpoint1() throws Exception {
        init();

        mockMvc.perform(
                post("/propriedades")
                        .content(ObjectToJson.convertString(propriedade1))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());
    }
    @Test
    public void testEndpoint2() throws Exception {
        init();

        mockMvc.perform(
                post("/propriedades")
                        .content(ObjectToJson.convertString(propriedade2))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());
    }
    @Test
    public void testEndpoint3() throws Exception {
        init();

        mockMvc.perform(
                post("/propriedades")
                        .content(ObjectToJson.convertString(propriedade3))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());
    }

    @Test
    public void testEndpointExceptionNameNull() throws Exception {
        init();

        propriedade1.setProp_name(null);

        mockMvc.perform(
                post("/propriedades")
                        .content(ObjectToJson.convertString(propriedade1))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isBadRequest());
    }
    @Test
    public void testEndpointExceptionNameBigger() throws Exception {
        init();

        propriedade1.setProp_name("Casa da maria na cidade natal dos pais dela, que é são paulo");

        mockMvc.perform(
                post("/propriedades")
                        .content(ObjectToJson.convertString(propriedade1))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isBadRequest());
                //.andExpect(content().json());
        //TODO aq
    }
    @Test
    public void testEndpointExceptionNameNotAllowed() throws Exception {
        init();

        propriedade1.setProp_name("casa 1");

        mockMvc.perform(
                post("/propriedades")
                        .content(ObjectToJson.convertString(propriedade1))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testEndpointExceptionDistrictNull() throws Exception {
        init();

        propriedade1.setProp_district(null);

        mockMvc.perform(
                post("/propriedades")
                        .content(ObjectToJson.convertString(propriedade1))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isBadRequest());
    }
    @Test
    public void testEndpointExceptionDistrictBigger() throws Exception {
        init();

        propriedade1.setProp_district("Bairro da cidade do Brasil que tem um nome muito grande");

        mockMvc.perform(
                post("/propriedades")
                        .content(ObjectToJson.convertString(propriedade1))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isBadRequest());
    }
    @Test
    public void testEndpointExceptionDistrictNotFound() throws Exception {
        init();

        propriedade1.setProp_district("Bigorrilho");

        mockMvc.perform(
                post("/propriedades")
                        .content(ObjectToJson.convertString(propriedade1))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isNotFound());
    }

    @Test
    public void testEndpointExceptionRoomNameNull() throws Exception {
        init();

        propriedade1.getRooms().get(0).setRoom_name(null);

        mockMvc.perform(
                post("/propriedades")
                        .content(ObjectToJson.convertString(propriedade1))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isBadRequest());
    }
    @Test
    public void testEndpointExceptionRoomNameBigger() throws Exception {
        init();

        propriedade1.getRooms().get(0).setRoom_name("Cozinha Especifica para vizitantes");

        mockMvc.perform(
                post("/propriedades")
                        .content(ObjectToJson.convertString(propriedade1))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isBadRequest());
    }
    @Test
    public void testEndpointExceptionRoomNameNotAllowed() throws Exception {
        init();

        propriedade1.getRooms().get(0).setRoom_name("cozinha");

        mockMvc.perform(
                post("/propriedades")
                        .content(ObjectToJson.convertString(propriedade1))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testEndpointExceptionRoomWidthNull() throws Exception {
        init();

        propriedade1.getRooms().get(0).setRoom_width(null);

        mockMvc.perform(
                post("/propriedades")
                        .content(ObjectToJson.convertString(propriedade1))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isBadRequest());
    }
    @Test
    public void testEndpointExceptionRoomWidthBigger() throws Exception {
        init();

        propriedade1.getRooms().get(0).setRoom_width(26.0);

        mockMvc.perform(
                post("/propriedades")
                        .content(ObjectToJson.convertString(propriedade1))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testEndpointExceptionRoomLengthNull() throws Exception {
        init();

        propriedade1.getRooms().get(0).setRoom_length(null);

        mockMvc.perform(
                post("/propriedades")
                        .content(ObjectToJson.convertString(propriedade1))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isBadRequest());
    }
    @Test
    public void testEndpointExceptionRoomLengthBigger() throws Exception {
        init();

        propriedade1.getRooms().get(0).setRoom_length(33.1);

        mockMvc.perform(
                post("/propriedades")
                        .content(ObjectToJson.convertString(propriedade1))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isBadRequest());
    }

}
