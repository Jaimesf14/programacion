package com.juego.clases;

import com.juego.habilidades.CuraCC;
import com.juego.habilidades.DanioCC;
import com.juego.habilidades.DanioDistancia;
import com.juego.habilidades.Habilidades;

import java.util.ArrayList;
import java.util.List;

public class Mago implements Clase{
    //Constructor vacio


    @Override
    public String getNombre() {
        return "Mago";
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
        return 90;
    }

    //Creamos un arrayList donde añadiremos las habilidades de cada clase
    public List<Habilidades> crearHabilidades(){
        ArrayList<Habilidades> h = new ArrayList<>();

        h.add(new DanioCC("Descarga Arcana","Una explosión mágica liberada a corta distancia.",15));
        h.add(new CuraCC("Transferencia Vital","El mago convierte su energía mágica en curación.",18));
        h.add(new DanioDistancia("Bola de Fuego","Un proyectil ígneo devastador lanzado a distancia.",35));
        return h;
    }
}