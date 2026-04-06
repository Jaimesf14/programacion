package rpg.model;

import java.util.HashMap;

public class Personajes {
    private int id;
    private String nombre;
    private int nivel;
    private int oro;
    private int vida_actual;
    private Razas raza;
    private Clases_RPG clase;
    private int id_ciudad_actual;
    private HashMap<Items,Integer> Inventario = new HashMap<>();

    public Personajes(int id, String nombre, int nivel, int oro, int vida_actual, Razas raza, Clases_RPG clase, int id_ciudad_actual) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.oro = oro;
        this.vida_actual = vida_actual;
        this.raza = raza;
        this.clase = clase;
        this.id_ciudad_actual = id_ciudad_actual;
    }
}
