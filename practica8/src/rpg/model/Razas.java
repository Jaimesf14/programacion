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

    public int getBonificador_vida() {
        return bonificador_vida;
    }

    public void setBonificador_vida(int bonificador_vida) {
        this.bonificador_vida = bonificador_vida;
    }

    public int getBonificador_fuerza() {
        return bonificador_fuerza;
    }

    public void setBonificador_fuerza(int bonificador_fuerza) {
        this.bonificador_fuerza = bonificador_fuerza;
    }

    @Override
    public String toString() {
        return "Razas{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", bonificador_vida=" + bonificador_vida +
                ", bonificador_fuerza=" + bonificador_fuerza +
                '}';
    }
}
