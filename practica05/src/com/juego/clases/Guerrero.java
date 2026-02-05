package com.juego.clases;

import com.juego.habilidades.*;

import java.util.ArrayList;
import java.util.List;

public class Guerrero implements Clase{
    //Creo el array como atributo
    private ArrayList<Habilidades> h;
    //Constructor para iniciar habilidades solo una vez
    public Guerrero(){
        this.h = new ArrayList<>();
        h.add(new DanioCC("Golpe Devastador","El guerrero arroja su arma con precisión para golpear a un enemigo lejano.",36,5));
        h.add(new CuraCC("Aliento de Batalla","Un gesto de ánimo en pleno combate que permite a un aliado resistir un poco más.",15,3));
        h.add(new DanioDistancia("Lanzamiento de Arma","El guerrero arroja su arma con precisión para golpear a un enemigo lejano.",60,1));
        h.add(new Explosion());
        h.add(new DanioCC("Furia", "Duplica el daño en las dos siguientes rondas",0,1));

    }

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

    //devuelve el array creado
    public ArrayList<Habilidades> getHabilidades(){
        return this.h;
    }
}
