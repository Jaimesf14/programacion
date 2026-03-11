package com.rpg.services;

import com.rpg.model.Ciudad;
import com.rpg.model.Personaje;
import com.rpg.utils.JsonHelper;
import com.rpg.utils.TxtHelper;

import java.util.List;

public class GestionMundo {
    private List<Personaje> personajes;
    private List<Ciudad> ciudades;
    private JsonHelper jsonHelper = new JsonHelper();
    private TxtHelper txtHelper = new TxtHelper();
    public void cargarTodo(){
    }
    public void crearPersonaje(String nombre, String raza, List<String> idsItems){


    }
}

