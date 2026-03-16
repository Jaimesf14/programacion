package com.rpg.services;


import com.rpg.handler.SobrecargaEquipamiento;
import com.rpg.model.Ciudad;
import com.rpg.model.Item;
import com.rpg.model.Personaje;
import com.rpg.utils.JsonHelper;
import com.rpg.utils.LoggerCustom;
import com.rpg.utils.TxtHelper;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


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
    public void crearPersonaje(String nombre, String raza, List<String> idsItems, int fuerza) {


        Personaje p = new Personaje(nombre, raza, 1, idsItems, fuerza);
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
        //try{
        //    if()
        //}
    }




    public void guardarCambios() {
        jsonHelper.writeList("practica07/ficheros/personajes.json", personajes);
    }


    public void mostrarPersonajes() {
        System.out.println("---Personajes iniciales---");
        for (Personaje p : personajes) {
            System.out.println("Personaje: " + p.getNombre());
            if (p.getEquipo() != null) {
                for (Item i : p.getEquipo()) {
                    System.out.println("  - " + i.getNombre());
                }
            }
        }
    }
    public void equipamientoInteligente() {
        for (Personaje p : personajes) {
            int cargaMax = p.getFuerza() * 5;
            int pesoMax = 0;
            for (String id : p.getEquipoIds()) {
                for (Item i : items) {
                    if (i.getId().equals(id)){
                        pesoMax += i.getPeso();
                        break;
                    }
                }
            }

            try{
                if(pesoMax < cargaMax){
                    LoggerCustom.log("[" + LocalDateTime.now() + "] INFO: Carga del personaje " + p.getNombre() + " es valida.");
                    throw new SobrecargaEquipamiento("El personaje "+ p.getNombre() + " tiene sobrecarga de equipamiento");
                }
            } catch (SobrecargaEquipamiento e) {
                LoggerCustom.log("[" + LocalDateTime.now() + "] ERROR: " + e.getMessage());
            }
        }
    }

}





//equipamiento inteligente modificar crear personajes para que el peso total de los items en equiposids no superen la capacidad de carga de los personajes, carga max= fuerzax5
//hay q crear una excepcion de sobrecarga de equipamiento
//crear en items peso y en personaje fuerza
