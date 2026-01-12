package com.juego.clases;

public class Guerrero implements Clase{
    /*public Guerrero(){
        super(3,0,0,120);
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
        return 120;
    }
}
