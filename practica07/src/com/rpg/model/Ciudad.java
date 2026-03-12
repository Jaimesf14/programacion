package com.rpg.model;

public class Ciudad {
    private String Nombre;
    private int poblacion;
    private String clima;
    private int riesgo;

    public Ciudad(String nombre, int poblacion, String clima, int riesgo){
        this.Nombre = nombre;
        this.poblacion = poblacion;
        this.clima = clima;
        this.riesgo = riesgo;
    }
    //Metodos

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public int getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(int riesgo) {
        this.riesgo = riesgo;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "nombre='" + Nombre + '\'' +
                ", poblacion=" + poblacion +
                ", clima='" + clima + '\'' +
                ", riesgo=" + riesgo +
                '}';
    }
}
