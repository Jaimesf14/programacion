package rpg.logic;


import rpg.model.Personajes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Estadisticas {
    private List<Personajes> lista;

    public Estadisticas() {
        this.lista = new ArrayList<>();
    }

    public void censoClases(){
        HashMap<Integer, String> clases = new HashMap<>();
        clases.put(1, "Guerrero");
        clases.put(2, "Mago");
        clases.put(3, "Picaro");
        clases.put(4, "Paladin");
        HashMap<Integer, Integer> censo = new HashMap<>();
        for (int i = 0; i < lista.size(); i++){
            Personajes p = lista.get(i);
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
