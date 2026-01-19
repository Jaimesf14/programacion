package com.juego.modelo;

import java.util.ArrayList;

public class gestorPersonajes {
    private ArrayList<Personaje> personajes = new ArrayList<>();

    public ArrayList<Personaje> getPersonajes() {

        return personajes;
    }
    public  void agregarPersonaje(Personaje p){
        personajes.add(p);

    }
}
