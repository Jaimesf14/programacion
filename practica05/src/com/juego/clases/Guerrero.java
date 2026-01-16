package com.juego.clases;

import com.juego.habilidades.CuraCC;
import com.juego.habilidades.DanioCC;
import com.juego.habilidades.DanioDistancia;
import com.juego.habilidades.Habilidades;

import java.util.ArrayList;
import java.util.List;

public class Guerrero implements Clase{
    /*public Guerrero(){
        super(3,0,0,120);
    }*/
    //Constructor vacio

    @Override
    public String getNombre() {
        return "Guerrero";
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
        return 120;
    }

    //Creamos un arrayList donde añadiremos las habilidades de cada clase
    public List<Habilidades> crearHabilidades(){
        ArrayList<Habilidades> h = new ArrayList<>();

        h.add(new DanioCC("Golpe Devastador","El guerrero arroja su arma con precisión para golpear a un enemigo lejano.",18));
        h.add(new CuraCC("Aliento de Batalla","Un gesto de ánimo en pleno combate que permite a un aliado resistir un poco más.",15));
        h.add(new DanioDistancia("Lanzamiento de Arma","El guerrero arroja su arma con precisión para golpear a un enemigo lejano.",30));
        return h;
    }
}
