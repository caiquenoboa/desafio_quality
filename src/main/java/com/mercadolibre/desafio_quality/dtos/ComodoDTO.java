package com.mercadolibre.desafio_quality.dtos;

public class ComodoDTO {
    private String room_name;
    private double room_area;

    public ComodoDTO() {
    }

    public ComodoDTO(String room_name, double room_area) {
        this.room_name = room_name;
        this.room_area = room_area;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public double getRoom_area() {
        return room_area;
    }

    public void setRoom_area(double room_area) {
        this.room_area = room_area;
    }
}

