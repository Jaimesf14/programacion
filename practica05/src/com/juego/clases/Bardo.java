package com.juego.clases;

import com.juego.habilidades.CuraCC;
import com.juego.habilidades.DanioCC;
import com.juego.habilidades.DanioDistancia;
import com.juego.habilidades.Habilidades;

import java.util.ArrayList;
import java.util.List;

public class Bardo implements Clase{
    //Constructor vacio


    @Override
    public String getNombre() {
        return "Bardo";
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

        h.add(new DanioCC("Golpe Rítmico","Un ataque marcado por el ritmo de la música.",15));
        h.add(new CuraCC("Melodía Reconfortante","Una melodía suave que calma y sana heridas.",22));
        h.add(new DanioDistancia("Nota Discordante","Una onda sonora que daña al enemigo desde lejos.",26));
        return h;
    }
}
