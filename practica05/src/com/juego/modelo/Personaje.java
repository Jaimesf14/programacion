package com.juego.modelo;

public class Personaje {
    //atributos
    private String nombre;
    private int fuerza;
    private int destreza;
    private int inteligencia;
    private int vidaBase;
    private String especialidad;
    private int vidaMax;


    //constructor
    public Personaje(String nombre, int fuerza, int destreza, int inteligencia, int vidaBase,
                     String especialidad, int vidaMax){
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.vidaBase = vidaBase;
        this.especialidad = especialidad;
        this.vidaMax = vidaMax;
    }


    //get y set


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getFuerza() {
        return fuerza;
    }


    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }


    public int getDestreza() {
        return destreza;
    }


    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }


    public int getInteligencia() {
        return inteligencia;
    }


    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }


    public int getVidaBase() {
        return vidaBase;
    }


    public void setVidaBase(int vidaBase) {
        this.vidaBase = vidaBase;
    }


    public String getEspecialidad() {
        return especialidad;
    }


    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }


    public int getVidaMax() {
        return vidaMax;
    }


    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }
}

    /*//atributo de los personajes
    private String nombre;
    private int fuerza;
    private int inteligencia;
    private int destreza;
    private int vida;
}*/
