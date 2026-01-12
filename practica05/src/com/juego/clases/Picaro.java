package com.juego.clases;

public class Picaro implements Clase{
    /*public Picaro(){
       super(0,0,3,105);
   }*/
    @Override
    public int getBonificacionFuerza() {
        return 0;
    }

    @Override
    public int getBonificacionInteligencia() {
        return 0;
    }

    @Override
    public int getBonificacionDestreza() {
        return 3;
    }

    @Override
    public int getVidaMax() {
        return 105;
    }



}
