package com.mercadolibre.desafio_quality.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class Propriedade {
    @NotNull(message = "O nome da propriedade não pode estar vazio.")
    @Size(max = 30, message = "O comprimento do nome não pode exceder 30 caracteres.")
    @Pattern(regexp = "[\\p{Lu}\\s].*", message = "O nome da propriedade deve começar com uma letra maiúscula.")
    private String prop_name;
    private String prop_district;
    private List<Comodo> rooms;

    public Propriedade() {
    }

    public Propriedade(String prop_name, String prop_district, List<Comodo> rooms) {
        this.prop_name = prop_name;
        this.prop_district = prop_district;
        this.rooms = rooms;
    }

    public String getProp_name() {
        return prop_name;
    }

    public void setProp_name(String prop_name) {
        this.prop_name = prop_name;
    }

    public String getProp_district() {
        return prop_district;
    }

    public void setProp_district(String prop_district) {
        this.prop_district = prop_district;
    }

    public List<Comodo> getRooms() {
        return rooms;
    }

    public void setRooms(List<Comodo> rooms) {
        this.rooms = rooms;
    }
}
