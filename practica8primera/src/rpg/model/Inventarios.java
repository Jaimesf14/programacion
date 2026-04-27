package rpg.model;

public class Inventarios {
    private int id_personaje;
    private int id_item;
    private int cantidad;

    public Inventarios(int id_personaje, int id_item, int cantidad) {
        this.id_personaje = id_personaje;
        this.id_item = id_item;
        this.cantidad = cantidad;
    }
}
