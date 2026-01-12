package com.juego.clases;

public class Sacerdote implements Clase {
    /*public Sacerdote(){
        super(3,0,0,95);
    }*/

    @Override
    public int getBonificacionFuerza() {
        return 3;
    }

    @Override
    public int getBonificacionInteligencia() {
        return 0;
    }

    @Override
    public int getBonificacionDestreza() {
        return 0;
    }

    @Override
    public int getVidaMax() {
        return 95;
    }
}
