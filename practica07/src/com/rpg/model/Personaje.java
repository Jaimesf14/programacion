package com.rpg.model;

import java.util.List;

public class Personaje {
    private String nombre;
    private String raza;
    private int nivel;
    //ids del Json
    private List<String> equipoIds;
    //items cargados en memoria
    private transient List<Item> equipo;//no modifica personajes.json

    public Personaje(String nombre, String raza, int nivel, List<String> equipoIds) {
        this.nombre = nombre;
        this.raza = raza;
        this.nivel = nivel;
        this.equipoIds= equipoIds;
    }

    //Metodo

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public List<String> getEquipoIds() {
        return equipoIds;
    }

    public void setEquipoIds(List<String> equipoIds) {
        this.equipoIds = equipoIds;
    }

    public List<Item> getEquipo() {
        return equipo;
    }

    public void setEquipo(List<Item> equipo) {
        this.equipo = equipo;
    }
}
