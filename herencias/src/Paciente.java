public class Paciente extends Persona implements Humano{
    public Paciente(String nombre, String dni, int edad, String sexo) {
        super(nombre, dni, edad, sexo);
    }


    @Override
    public void respirar() {

    }

    @Override
    public void estaEnfermo() {

    }
}