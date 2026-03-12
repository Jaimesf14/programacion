package com.rpg.services;

import com.rpg.model.Ciudad;
import com.rpg.model.Item;
import com.rpg.model.Personaje;
import com.rpg.utils.JsonHelper;
import com.rpg.utils.LoggerCustom;
import com.rpg.utils.TxtHelper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GestionMundo {
    private List<Personaje> personajes;
    private List<Ciudad> ciudades;
    private List<Item> items;
    private JsonHelper jsonHelper = new JsonHelper();

    public void cargarTodo(){
        //Cargar las ciudades
        ciudades = TxtHelper.leerCiudades();

        //Cargar los items
        items = jsonHelper.readList("practica07/ficheros/items.json", Item.class);

       //Cargar personajes
        personajes = jsonHelper.readList("practica07/ficheros/personajes.json", Personaje.class);

        // Vincular items a personajes
        for (Personaje p : personajes) {
            List<Item> equipoReal = new ArrayList<>();
            if (p.getEquipoIds() != null) {
                for (String id : p.getEquipoIds()) {
                    // Buscar item en la lista
                    for (Item i : items) {
                        if (i.getId().equals(id)) {
                            equipoReal.add(i);
                            break;
                        }
                    }
                }
            }
            // Asignamos los objetos item al personaje
            p.setEquipo(equipoReal);
        }
    }
    //crear personajes
    public void crearPersonaje(String nombre, String raza, List<String> idsItems){
        Personaje p = new Personaje(nombre, raza, 1, idsItems);
        List<Item> equipoReal = new ArrayList<>();
        //vinculamos los ids de los items con objetos reales
        for (String id : idsItems){
            for (Item i : items){
                if (i.getId().equals(id)){
                    equipoReal.add(i);
                    break;
                }
            }
        }
        p.setEquipo(equipoReal);
        personajes.add(p);
        LoggerCustom.log("[" + LocalDateTime.now() + "] INFO: Personaje creado -> " + nombre);

    }


    public void guardarCambios() {
        jsonHelper.writeList("practica07/ficheros/personajes.json", personajes);
    }

    public void mostrarPersonajes() {
        for (Personaje p : personajes) {
            System.out.println("Personaje: " + p.getNombre());
            if (p.getEquipo() != null) {
                for (Item i : p.getEquipo()) {
                    System.out.println("  - " + i.getNombre());
                }
            }
        }
    }
}

