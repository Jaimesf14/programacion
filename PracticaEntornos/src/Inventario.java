import java.util.HashMap;

public class Inventario {
    private HashMap<String, Integer> stock;
    private HashMap<String, Double> productos;
    private Producto producto;

    public Inventario(HashMap<String, Boolean> stock, HashMap<String, Boolean> productos, Producto producto){
        this.stock = new HashMap<>();
        this.productos = new HashMap<>();
        this.producto = producto;
    }
    //GET Y SET

    public HashMap<String, Integer> getStock() {
        return stock;
    }

    public void setStock(HashMap<String, Integer> stock) {
        this.stock = stock;
    }

    public HashMap<String, Double> getProductos() {
        return productos;
    }

    public void setProductos(HashMap<String, Double> productos) {
        this.productos = productos;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    //METODOS
    public void añadirProductos(){
        productos.put(producto.getNombre(), producto.getPrecio());
    }
    public void añadirStock(int cantidad){
        stock.put(producto.getNombre(), cantidad);
    }
    public void consultarStock(String nombre){
        stock.containsKey(nombre);
    }
    public void consultarProducto(String nombre){
        productos.containsKey(nombre);
    }
}
