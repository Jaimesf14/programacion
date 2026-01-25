package com.juego.clases;

import com.juego.habilidades.CuraCC;
import com.juego.habilidades.DanioCC;
import com.juego.habilidades.DanioDistancia;
import com.juego.habilidades.Habilidades;

import java.util.ArrayList;
import java.util.List;

public class Sacerdote implements Clase {
    /*public Sacerdote(){
        super(3,0,0,95);
    }*/
    //Constructor vacio
    public Sacerdote(){

    }

    @Override
    public String getNombre() {
        return "Sacerdote";
    }

    //Metodos interfaz
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

    //Creamos un arrayList donde añadiremos las habilidades de cada clase
    public ArrayList<Habilidades> getHabilidades(){
        ArrayList<Habilidades> h = new ArrayList<>();

        h.add(new DanioCC("Golpe Consagrado","Un ataque bendecido que canaliza poder sagrado.",29,5));
        h.add(new CuraCC("Sanación Directa","Una oración convertida en energía curativa.",30,3));
        h.add(new DanioDistancia("Castigo Divino","Un ataque de luz que juzga al enemigo desde lejos.",61,1));
        return h;
    }

}
