package com.juego.clases;

import com.juego.habilidades.CuraCC;
import com.juego.habilidades.DanioCC;
import com.juego.habilidades.DanioDistancia;
import com.juego.habilidades.Habilidades;

import java.util.ArrayList;
import java.util.List;

public class Druida implements Clase{
    /*public Druida(){
    }
    public ArrayList
    public void estadisticas*/
    @Override
    public String getNombre() {
        return "Druida";
    }

    //Metodos interfaz
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

    @Override
    public ArrayList<Habilidades> getHabilidades(){
        ArrayList<Habilidades> h = new ArrayList<>();
        //Añadimos cada tipo de habilidad al array.
        h.add(new DanioCC("Garra Salvaje","El druida ataca con la ferocidad de una bestia.",30,5));
        h.add(new CuraCC("Toque Rejuvenecedor","La energía de la naturaleza fluye para sanar al aliado.",25,3));
        h.add(new DanioDistancia("Espina Perforante","Una espina mágica disparada contra el enemigo.",56,1));
        return h;
    }
}
