import java.util.ArrayList;

public class Bebida extends Producto{
    //atributos
    protected String tamaño;
    public Bebida(String tamaño, String nombre, double precio, double descuento, ArrayList<Producto> comboFiesta) {
        super(nombre, precio, descuento, comboFiesta);
        this.tamaño = tamaño; //XL, large, small, medium
    }
    //GET Y SET

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }
}
