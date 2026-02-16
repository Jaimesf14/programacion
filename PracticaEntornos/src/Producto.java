import java.util.ArrayList;

public class Producto {
    private String nombre;
    private double precio;
    private double descuento;
    private ArrayList<Producto> comboFiesta;
    public Producto(String nombre, double precio, double descuento, ArrayList<Producto> comboFiesta){
        this.nombre = nombre;
        this.precio = precio;
        this.descuento = descuento;
        this.comboFiesta = new ArrayList<>();
    }
    //GET Y SET


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public ArrayList<Producto> getComboFiesta() {
        return comboFiesta;
    }

    public void setComboFiesta(ArrayList<Producto> comboFiesta) {
        this.comboFiesta = comboFiesta;
    }

    //METODOS
    public double calcularPrecioComboFiesta() {
        double res = precio * descuento;
        return res;
    }
}
