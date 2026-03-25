package rpg.model;

public class Personaje_Habilidades {
    private int id_personaje;
    private int id_habilidad;
    private boolean equipada_combate;

    public Personaje_Habilidades(int id_personaje, int id_habilidad, boolean equipada_combate) {
        this.id_personaje = id_personaje;
        this.id_habilidad = id_habilidad;
        this.equipada_combate = equipada_combate;
    }
}
