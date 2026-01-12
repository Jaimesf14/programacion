package com.juego.clases;

public class Paladin implements Clase{
    /*public Paladin(){
        super(2,1,0,115);
    }*/

    @Override
    public int getBonificacionFuerza() {
        return 2;
    }

    @Override
    public int getBonificacionInteligencia() {
        return 1;
    }

    @Override
    public int getBonificacionDestreza() {
        return 0;
    }

    @Override
    public int getVidaMax() {
        return 115;
    }
}
