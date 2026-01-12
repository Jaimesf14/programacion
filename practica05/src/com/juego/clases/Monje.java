package com.juego.clases;

public class Monje implements Clase{
    /*public Monje(){
        super(2,0,1,110);
    }*/

    @Override
    public int getBonificacionFuerza() {
        return 2;
    }

    @Override
    public int getBonificacionInteligencia() {
        return 0;
    }

    @Override
    public int getBonificacionDestreza() {
        return 1;
    }

    @Override
    public int getVidaMax() {
        return 110;
    }
}
