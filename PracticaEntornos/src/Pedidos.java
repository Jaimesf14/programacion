import java.util.HashMap;

public class Pedidos {
    private HashMap <Boolean, Producto> lineas;
    private boolean cancelado;
    private double precio;
    private double descuento;
    private int fechaInicio;
    public Pedidos(HashMap<Boolean, Producto> lineas, boolean cancelado, double precio, double descuento, int fechaInicio){
        this.lineas = new HashMap<>();
        this.cancelado = false;
        this.precio = precio;
        this.descuento = 0.05;
        this.fechaInicio = fechaInicio;
    }
    //Get y set
    public boolean getCancelado() {
        return cancelado;
    }

    public int getFechaInicio() {
        return fechaInicio;
    }

    public double getDescuento() {
        return descuento;
    }

    public double getPrecio() {
        return precio;
    }

    public HashMap<Boolean, Producto> getLineas() {
        return lineas;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setFechaInicio(int fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }

    public void setLineas(HashMap<Boolean, Producto> lineas) {
        this.lineas = lineas;
    }

    //Metodos
    public boolean cancelarPedido(){

        if(!cancelado){
            return true;
        }
        return false;
    }
    public double calcularPrecio(){
        double res = precio*descuento;
        return res;
    }
}
