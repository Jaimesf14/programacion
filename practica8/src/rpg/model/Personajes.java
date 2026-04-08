package rpg.model;

import java.util.HashMap;

public class Personajes {
    private int id;
    private String nombre;
    private int nivel;
    private int oro;
    private int vida_actual;
    private int id_raza;
    private int id_clase;
    private int id_ciudad_actual;
    private HashMap<Habilidades, Boolean> habilidades;
    private HashMap<Items,Integer> inventario;

    public Personajes(int id, String nombre, int nivel, int oro, int vida_actual, int id_raza, int id_clase, int id_ciudad_actual) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.oro = oro;
        this.vida_actual = vida_actual;
        this.id_raza = id_raza;
        this.id_clase = id_clase;
        this.id_ciudad_actual = id_ciudad_actual;
        this.habilidades = new HashMap<>();
        this.inventario =new HashMap<>();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public int getVida_actual() {
        return vida_actual;
    }

    public void setVida_actual(int vida_actual) {
        this.vida_actual = vida_actual;
    }

    public int getId_raza() {
        return id_raza;
    }

    public void setId_raza(int id_raza) {
        this.id_raza = id_raza;
    }

    public int getId_clase() {
        return id_clase;
    }

    public void setId_clase(int id_clase) {
        this.id_clase = id_clase;
    }

    public int getId_ciudad_actual() {
        return id_ciudad_actual;
    }

    public void setId_ciudad_actual(int id_ciudad_actual) {
        this.id_ciudad_actual = id_ciudad_actual;
    }

    public HashMap<Habilidades, Boolean> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(HashMap<Habilidades, Boolean> habilidades) {
        this.habilidades = habilidades;
    }

    public HashMap<Items, Integer> getInventario() {
        return inventario;
    }

    public void setInventario(HashMap<Items, Integer> inventario) {
        this.inventario = inventario;
    }

    @Override
    public String toString() {
        return "Personajes{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", oro=" + oro +
                ", vida_actual=" + vida_actual +
                ", id_raza=" + id_raza +
                ", id_clase=" + id_clase +
                ", id_ciudad_actual=" + id_ciudad_actual +
                ", habilidades=" + habilidades +
                ", inventario=" + inventario +
                '}';
    }
}
