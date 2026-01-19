package com.juego.razas;

import com.juego.modelo.Personaje;

public class Elfo implements Raza {
    //atributos
    private int fuerza;
    private int inteligencia;
    private int destreza;
    private int vidaBase;
    private String especialidad;




    //constructor
    public Elfo(int fuerza, int inteligencia, int destreza,  int vidaBase,
                String especialidad){


        this.fuerza = 4;
        this.inteligencia = 6;
        this.destreza = 7;
        this.vidaBase = 90;
        this.especialidad = "Agilidad: Ideal para Pícaros, Magos y Bardos.";
    }


    // get y set


    public int getFuerza() {
        return fuerza;
    }


    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }


    public int getInteligencia() {
        return inteligencia;
    }


    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }


    public int getDestreza() {
        return destreza;
    }


    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }


    public int getVidaBase() {
        return vidaBase;
    }


    public void setVidaBase(int vidaBase) {
        this.vidaBase = vidaBase;
    }


    @Override
    public void bonificadorRaza(Personaje p) {
        p.setFuerza(p.getFuerza() + this.getFuerza());
        p.setInteligencia(p.getInteligencia() + this.getInteligencia());
        p.setDestreza(p.getDestreza() + this.getDestreza());
        p.setVidaBase(p.getVidaBase() + this.getVidaBase());
        }
    }
   /* public Elfo(){
        super("Elfo",4,6,7,90,"Agilidad: Ideal para Pícaros, Magos y Bardos.");
    }
    //Constructor vacio
    public Elfo(){
    }

    //Metodos interfaz
    @Override
    public String getNombre() {
        return "Elfo";
    }

    @Override
    public int getFuerza() {
        return 4;
    }

    @Override
    public int getInteligencia() {
        return 6;
    }

    @Override
    public int getDestreza() {
        return 7;
    }

    @Override
    public int getVidaBase() {
        return 90;
    }

    @Override
    public String getEspecialidad() {
        return "Agilidad: Ideal para Pícaros, Magos y Bardos.";
    }
}*/
