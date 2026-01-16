package com.juego.clases;

import com.juego.habilidades.CuraCC;
import com.juego.habilidades.DanioCC;
import com.juego.habilidades.DanioDistancia;
import com.juego.habilidades.Habilidades;

import java.util.ArrayList;
import java.util.List;

public class Monje implements Clase{
    /*public Monje(){
        super(2,0,1,110);
    }*/
    //Constructor vacio
    public Monje(){

    }

    @Override
    public String getNombre() {
        return "Monje";
    }

    //Metodos interfaz
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

    //Creamos un arrayList donde añadiremos las habilidades de cada clase
    public List<Habilidades> crearHabilidades(){
        ArrayList<Habilidades> h = new ArrayList<>();

        h.add(new DanioCC("Puño del Dragón","Un golpe veloz cargado de energía interna.",17));
        h.add(new CuraCC("Flujo de Chi","El monje transmite su energía vital para restaurar la salud.",20));
        h.add(new DanioDistancia("Onda de Chi","Una proyección de energía espiritual lanzada desde la distancia.",26));
        return h;
    }
}
