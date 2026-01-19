package com.juego.razas;

import com.juego.modelo.Personaje;

public class Enano implements Raza {
    //Metodos interfaz
    @Override
    public String getNombre(){
        return "Enano";
    }

    @Override
    public int getFuerza() {
        return 7;
    }

    @Override
    public int getInteligencia() {
        return 4;
    }

    @Override
    public int getDestreza() {
        return 4;
    }

    @Override
    public int getVidaBase() {
        return 110;
    }

    @Override
    public String getEspecialidad() {
        return "Resistencia: Ideal para Guerreros y Paladines.";
    }
}
    /*//atributos
    private String nombre;
    private int fuerza;
    private int inteligencia;
    private int destreza;
    private int vidaBase;
    private String especialidad;




    //constructor
    public Enano(String nombre, int fuerza, int inteligencia, int destreza,  int vidaBase,
                 String especialidad){

        this.nombre = "Enano";
        this.fuerza = 7;
        this.inteligencia = 4;
        this.destreza = 4;
        this.vidaBase = 110;
        this.especialidad = "Resistencia: Ideal para Guerreros y Paladines.";
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
    public Enano() {
        super("Enano",7,4,4,110,"Resistencia: Ideal para Guerreros y Paladines.");

    //Constructor vacio
    public Enano(){

    }
*/

