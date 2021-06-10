package com.mercadolibre.desafio_quality.models;

import java.util.List;

public class Propriedade {

    private String prop_name;
    private String prop_district;
    private List<Comodo> comodoList;

    public Propriedade() {
    }

    public Propriedade(String prop_name, String prop_district, List<Comodo> comodoList) {
        this.prop_name = prop_name;
        this.prop_district = prop_district;
        this.comodoList = comodoList;
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

    public List<Comodo> getComodoList() {
        return comodoList;
    }

    public void setComodoList(List<Comodo> comodoList) {
        this.comodoList = comodoList;
    }
}
