package com.juego.clases;

import com.juego.habilidades.CuraCC;
import com.juego.habilidades.DanioCC;
import com.juego.habilidades.DanioDistancia;
import com.juego.habilidades.Habilidades;

import java.util.ArrayList;
import java.util.List;

public class Picaro implements Clase{
    /*public Picaro(){
       super(0,0,3,105);
   }*/
    //Constructor vacio
    public Picaro(){

    }

    @Override
    public String getNombre() {
        return "Picaro";
    }

    //Metodos interfaz
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

    //Creamos un arrayList donde añadiremos las habilidades de cada clase
    public ArrayList<Habilidades> getHabilidades(){
        ArrayList<Habilidades> h = new ArrayList<>();

        h.add(new DanioCC("Puñalada Traicionera","Un ataque rápido dirigido a puntos vitales.",25));
        h.add(new CuraCC("Primeros Auxilios","Uso rápido de vendas y técnicas básicas para curar heridas.",15));
        h.add(new DanioDistancia("Daga Arrojadiza","Una daga lanzada con precisión mortal.",32));
        return h;
    }

}
