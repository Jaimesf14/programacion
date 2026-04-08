package rpg.model;

public class Razas {
    private int id;
    private String nombre;
    private int bonificador_vida;
    private int bonificador_fuerza;

    public Razas(int id, String nombre, int bonificador_vida, int bonificador_fuerza) {
        this.id = id;
        this.nombre = nombre;
        this.bonificador_vida = bonificador_vida;
        this.bonificador_fuerza = bonificador_fuerza;
    }

}
