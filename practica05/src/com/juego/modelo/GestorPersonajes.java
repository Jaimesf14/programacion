package com.juego.modelo;

import com.juego.clases.Guerrero;
import com.juego.clases.Mago;
import com.juego.clases.Picaro;
import com.juego.razas.Elfo;
import com.juego.razas.Enano;
import com.juego.razas.Humano;

import java.util.ArrayList;

public class GestorPersonajes {
    private ArrayList<Personaje> listaPersonajes = new ArrayList<>();
    public GestorPersonajes(){
    //Personajes creados por defecto
        listaPersonajes.add(new Personaje("Snape", new Humano(), new Mago(), new Mago().getHabilidades()));
        listaPersonajes.add(new Personaje("Dobby", new Elfo(), new Mago(), new Mago().getHabilidades()));
        listaPersonajes.add(new Personaje("Tyrion", new Enano(), new Guerrero(), new Guerrero().getHabilidades()));
        listaPersonajes.add(new Personaje("Fermin", new Humano(), new Picaro(), new Picaro().getHabilidades()));
    }

    //Metodo get
    public ArrayList<Personaje> getListaPersonajes() {
        return listaPersonajes;
    }

    //Metodo para añadir personajes nuevo
    public void aniadirPresonaje(Personaje p){
        listaPersonajes.add(p);
    }
}

