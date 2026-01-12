package com.juego.razas;

public class Enano implements Raza {
    /*public Enano() {
        super("Enano",7,4,4,110,"Resistencia: Ideal para Guerreros y Paladines.");
*/
    @Override
    public String getNombre(){
        return "Enano";
    }

    @Override
    public int getFuerza() {
        return 0;
    }

    @Override
    public int getInteligencia() {
        return 0;
    }

    @Override
    public int getDestreza() {
        return 0;
    }

    @Override
    public int getVidaBase() {
        return 0;
    }

    @Override
    public String getEspecialidad() {
        return "Resistencia: Ideal para Guerreros y Paladines.";
    }
}
