package com.juego.razas;

public class Elfo implements Raza {
   /* public Elfo(){
        super("Elfo",4,6,7,90,"Agilidad: Ideal para Pícaros, Magos y Bardos.");
    }*/
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
}
