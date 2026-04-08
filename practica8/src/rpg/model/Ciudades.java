package rpg.model;

public class Ciudades {
    private int id;
    private String nombre;
    private int nivel_minimo_acceso;

    public Ciudades(int id, String nombre, int nivel_minimo_acceso) {
        this.id = id;
        this.nombre = nombre;
        this.nivel_minimo_acceso = nivel_minimo_acceso;
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

    public int getNivel_minimo_acceso() {
        return nivel_minimo_acceso;
    }

    public void setNivel_minimo_acceso(int nivel_minimo_acceso) {
        this.nivel_minimo_acceso = nivel_minimo_acceso;
    }

    @Override
    public String toString() {
        return "Ciudades{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nivel_minimo_acceso=" + nivel_minimo_acceso +
                '}';
    }
}
