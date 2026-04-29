package rpg.model;

import java.util.HashMap;

public class Personajes {
    private int id;
    private String nombre;
    private int nivel;
    private int oro;
    private int vida_actual;
    private Razas razas;
    private ClasesRPG clasesRPG;
    private Ciudades ciudades;
    private HashMap<Items, Integer> inventario;
    private HashMap<Habilidades, Boolean> habilidades_equipadas;

    public Personajes(int id, String nombre, int nivel, int oro, int vida_actual, Razas razas, ClasesRPG clasesRPG, Ciudades ciudades) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.oro = oro;
        this.vida_actual = vida_actual;
        this.razas = razas;
        this.clasesRPG = clasesRPG;
        this.ciudades = ciudades;
        this.inventario = new HashMap<>();
        this.habilidades_equipadas = new HashMap<>();
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

    public Razas getRazas() {
        return razas;
    }

    public void setRazas(Razas razas) {
        this.razas = razas;
    }

    public ClasesRPG getClasesRPG() {
        return clasesRPG;
    }

    public void setClasesRPG(ClasesRPG clasesRPG) {
        this.clasesRPG = clasesRPG;
    }

    public Ciudades getCiudades() {
        return ciudades;
    }

    public void setCiudades(Ciudades ciudades) {
        this.ciudades = ciudades;
    }

    public HashMap<Items, Integer> getInventario() {
        return inventario;
    }

    public void setInventario(HashMap<Items, Integer> inventario) {
        this.inventario = inventario;
    }

    public HashMap<Habilidades, Boolean> getHabilidades_equipadas() {
        return habilidades_equipadas;
    }

    public void setHabilidades_equipadas(HashMap<Habilidades, Boolean> habilidades_equipadas) {
        this.habilidades_equipadas = habilidades_equipadas;
    }

    @Override
    public String toString() {
        return "Personajes{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", oro=" + oro +
                ", vida_actual=" + vida_actual +
                ", razas=" + razas +
                ", clasesRPG=" + clasesRPG +
                ", ciudades=" + ciudades +
                ", inventario=" + inventario +
                ", habilidades_equipadas=" + habilidades_equipadas +
                '}';
    }
}
