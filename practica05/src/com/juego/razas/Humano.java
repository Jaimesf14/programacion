package com.juego.razas;

import com.juego.modelo.Personaje;

public class Humano implements Raza {
    //atributos
    private int fuerza;
    private int inteligencia;
    private int destreza;
    private int vidaBase;
    private String especialidad;

    //constructor
    public Humano(int fuerza, int inteligencia, int destreza,  int vidaBase,
                  String especialidad){


        this.fuerza = 5;
        this.inteligencia = 5;
        this.destreza = 5;
        this.vidaBase = 100;
        this.especialidad = "Equilibrado: Versátil para cualquier clase";
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
    /*public Humano() {
       super ("Humano",5,5,5,100,"Equilibrado: Versátil para cualquier clase");
   }
    //Constructor vacio
    public Humano(){

    }

    //Metodos interfaz
    @Override
    public String getNombre() {
        return "Humano";
    }

    @Override
    public int getFuerza() {
        return 5;
    }

    @Override
    public int getInteligencia() {
        return 5;
    }

    @Override
    public int getDestreza() {
        return 5;
    }

    @Override
    public int getVidaBase() {
        return 100;
    }

    @Override
    public String getEspecialidad() {
        return "Equilibrado: Versátil para cualquier clase";
    }


}
*/