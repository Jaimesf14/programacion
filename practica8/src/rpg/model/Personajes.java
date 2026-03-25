package rpg.model;

public class Personajes {
    private int id;
    private String nombre;
    private int oro;
    private int vida_actual;
    private int id_raza;
    private int id_clase;
    private int id_ciudad_actual;

    public Personajes(int id, String nombre, int oro, int vida_actual, int id_raza, int id_clase, int id_ciudad_actual) {
        this.id = id;
        this.nombre = nombre;
        this.oro = oro;
        this.vida_actual = vida_actual;
        this.id_raza = id_raza;
        this.id_clase = id_clase;
        this.id_ciudad_actual = id_ciudad_actual;
    }
}
