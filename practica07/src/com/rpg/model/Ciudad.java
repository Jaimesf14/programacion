package com.rpg.model;

public class Ciudad {
    String Nombre;
    int poblacion;
    String clima;
    int riesgo;

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
}
