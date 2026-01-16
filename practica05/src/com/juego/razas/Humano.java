package com.juego.razas;

public class Humano implements Raza {
    /*public Humano() {
       super ("Humano",5,5,5,100,"Equilibrado: Versátil para cualquier clase");
   }*/
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
