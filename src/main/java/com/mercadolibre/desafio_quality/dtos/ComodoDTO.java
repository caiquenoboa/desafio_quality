package com.mercadolibre.desafio_quality.dtos;

import java.util.Objects;

public class ComodoDTO {
    private String room_name;
    private double room_area;

    public ComodoDTO() {
    }

    public ComodoDTO(String room_name, double room_area) {
        this.room_name = room_name;
        this.room_area = room_area;
    }

    @Override
    public String toString() {
        return "ComodoDTO{" +
                "room_name='" + room_name + '\'' +
                ", room_area=" + room_area +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComodoDTO)) return false;
        ComodoDTO comodoDTO = (ComodoDTO) o;
        return Double.compare(comodoDTO.room_area, room_area) == 0 && room_name.equals(comodoDTO.room_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room_name, room_area);
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

