package com.juego.clases;

import com.juego.habilidades.CuraCC;
import com.juego.habilidades.DanioCC;
import com.juego.habilidades.DanioDistancia;
import com.juego.habilidades.Habilidades;

import java.util.ArrayList;
import java.util.List;

public class Druida implements Clase{
    /*public Druida(){
        super(2,1,0,100);
    }*/
    //Constructor vacio


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

    //Creamos un arrayList donde añadiremos las habilidades de cada clase
    public List<Habilidades> crearHabilidades(){
        ArrayList<Habilidades> h = new ArrayList<>();

        h.add(new DanioCC("Garra Salvaje","El druida ataca con la ferocidad de una bestia.",15));
        h.add(new CuraCC("Toque Rejuvenecedor","La energía de la naturaleza fluye para sanar al aliado.",25));
        h.add(new DanioDistancia("Espina Perforante","Una espina mágica disparada contra el enemigo.",28));
        return h;
    }
}
