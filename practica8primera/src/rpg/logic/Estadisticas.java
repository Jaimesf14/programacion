package rpg.logic;


import rpg.dao.PersonajeDAO;
import rpg.model.Personajes;

import java.util.*;

public class Estadisticas {
    private PersonajeDAO personajeDAO = new PersonajeDAO();

    //TOP TRES MAS RICOS
    public void topRicos() {

        List<Personajes> lista = personajeDAO.cargarPersonajes();

        Collections.sort(lista, new Comparator<Personajes>() {
            public int compare(Personajes a, Personajes b) {
                return b.getOro() - a.getOro();
            }
        });

        System.out.println("--- TOP 3 JUGADORES MAS RICOS ---");

        for (int i = 0; i < 3 && i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i).getNombre() + " = " + lista.get(i).getOro());
        }
    }

    //CONTAR PERSONAJES DE CADA CLASE
    public void censoClases(){
        List<Personajes> personajes = personajeDAO.cargarPersonajes();

        HashMap<Integer, String> clases = new HashMap<>();
        clases.put(1, "Guerrero");
        clases.put(2, "Mago");
        clases.put(3, "Picaro");
        clases.put(4, "Paladin");
        HashMap<Integer, Integer> censo = new HashMap<>();
        for (int i = 0; i < personajes.size(); i++){
            Personajes p = personajes.get(i);
            int clase = p.getId_clase();
            if (censo.containsKey(clase)){
                censo.put(clase, censo.get(clase) + 1);
            } else {
                censo.put(clase, 1);
            }
        }
        for ( int id : censo.keySet()){
            String nombre = clases.get(id);
            System.out.println(nombre + " - " + censo.get(id));
        }
    }
}
