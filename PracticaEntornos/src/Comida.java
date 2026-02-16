import java.util.ArrayList;

public class Comida extends Producto{
    //atributos
    protected String alergenos;
    protected int tiempoCocinado;
    //constructor
    public Comida(String alergenos, int tirmpoCocinado, String nombre, double precio, double descuento, ArrayList<Producto> comboFiesta) {
        super(nombre, precio, descuento, comboFiesta);
        this.alergenos = alergenos;
        this.tiempoCocinado = tirmpoCocinado;
    }
    //GET Y SET

    public String getAlergenos() {
        return alergenos;
    }

    public void setAlergenos(String alergenos) {
        this.alergenos = alergenos;
    }

    public int getTiempoCocinado() {
        return tiempoCocinado;
    }

    public void setTiempoCocinado(int tiempoCocinado) {
        this.tiempoCocinado = tiempoCocinado;
    }
}
