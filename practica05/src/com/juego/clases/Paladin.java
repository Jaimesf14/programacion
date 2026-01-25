package com.juego.clases;

import com.juego.habilidades.CuraCC;
import com.juego.habilidades.DanioCC;
import com.juego.habilidades.DanioDistancia;
import com.juego.habilidades.Habilidades;

import java.util.ArrayList;
import java.util.List;

public class Paladin implements Clase{
    /*public Paladin(){
        super(2,1,0,115);
    }*/
    //Constructor vacio
    public Paladin(){

    }
    //Metodos interfaz
    @Override
    public String getNombre() {
        return "Paladín";
    }

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

    //Creamos un arrayList donde añadiremos las habilidades de cada clase
    public ArrayList<Habilidades> getHabilidades(){
        ArrayList<Habilidades> h = new ArrayList<>();

        h.add(new DanioCC("Espada Sagrada","Un tajo bendecido que combina acero y energía divina.",32,5));
        h.add(new CuraCC("Imposición de Manos","El paladín canaliza su fe para sanar heridas con un toque.",50,3));
        h.add(new DanioDistancia("Rayo de Fe","Un haz de luz sagrada que castiga a los enemigos a distancia.",56,1));
        return h;
    }
}
