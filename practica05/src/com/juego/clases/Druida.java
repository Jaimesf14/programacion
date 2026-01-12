package com.juego.clases;

public class Druida implements Clase{
    /*public Druida(){
        super(2,1,0,100);
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
        return 100;
    }

}
