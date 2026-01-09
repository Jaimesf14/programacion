public class Persona implements Humano {
    private String nombre;
    private String dni;
    private int edad;
    private String sexo;
    public Persona(String nombre, String dni, int edad, String sexo){
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public void respirar() {

    }

    @Override
    public void estaEnfermo() {

    }
}
