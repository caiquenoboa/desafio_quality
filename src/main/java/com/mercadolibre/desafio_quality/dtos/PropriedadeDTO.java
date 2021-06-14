package com.mercadolibre.desafio_quality.dtos;

import com.mercadolibre.desafio_quality.models.Comodo;
import com.mercadolibre.desafio_quality.models.Propriedade;

import java.util.List;

public class PropriedadeDTO {
    private String prop_name;
    private String prop_district;
    private List<ComodoDTO> rooms;
    private double prop_area;
    private double prop_price;
    private ComodoDTO bigger_room;

    public PropriedadeDTO() {
    }

    public PropriedadeDTO(Propriedade propriedade, List<ComodoDTO> rooms, double prop_area, double prop_price, ComodoDTO bigger_room) {
        this.prop_name = propriedade.getProp_name();
        this.prop_district = propriedade.getProp_district();
        this.rooms = rooms;
        this.prop_area = prop_area;
        this.prop_price = prop_price;
        this.bigger_room = bigger_room;
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

    public List<ComodoDTO> getRooms() {
        return rooms;
    }

    public void setRooms(List<ComodoDTO> rooms) {
        this.rooms = rooms;
    }

    public double getProp_area() {
        return prop_area;
    }

    public void setProp_area(double prop_area) {
        this.prop_area = prop_area;
    }

    public double getProp_price() {
        return prop_price;
    }

    public void setProp_price(double prop_price) {
        this.prop_price = prop_price;
    }

    public ComodoDTO getBigger_room() {
        return bigger_room;
    }

    public void setBigger_room(ComodoDTO bigger_room) {
        this.bigger_room = bigger_room;
    }
}
