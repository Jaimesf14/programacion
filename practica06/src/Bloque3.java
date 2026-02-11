import java.util.ArrayList;
import java.util.HashMap;

public class Bloque3 {

    /*El Sistema de Comercio y Precios Dinámicos: Crea un HashMap<String, Double> con los precios base de varios items.
    Luego, crea un HashMap<String, ArrayList<String>> que represente las Ciudades y los Items en Stock que tienen.
    El Reto: Escribe un metodo que reciba el nombre de una ciudad. Si la ciudad tiene más de 5 items en stock, aplica
    un "impuesto de lujo" aumentando un 10% el precio de sus items en el mapa de precios base solo para esa transacción.
 */

    public void ComerciosPrecios(){
        System.out.println("---Ejercicio 11---");
        //Crea un HashMap<String, Double> con los precios base de varios items.
        HashMap<String, Double> preciosItems = new HashMap<>();
        preciosItems.put("Carne", 5.60);
        preciosItems.put("Leche", 2.70);
        preciosItems.put("Huevos", 7.80);
        preciosItems.put("Verdura", 4.50);
        preciosItems.put("Espada", 20.00);
        preciosItems.put("Pico", 15.25);
        preciosItems.put("Hacha", 12.50);

        //Luego, crea un HashMap<String, ArrayList<String>> que represente las Ciudades y los Items en Stock que tienen.
        HashMap<String, ArrayList<String>> ciudadItemsStock = new HashMap<>();
        ArrayList<String> stock1 = new ArrayList<>();
        stock1.add("Espada");
        stock1.add("Espada");
        stock1.add("Carne");
        stock1.add("Carne");
        stock1.add("Carne");
        stock1.add("Verdura");

        ArrayList<String> stock2 = new ArrayList<>();
        stock2.add("Hacha");
        stock2.add("Leche");
        stock2.add("Huevos");

        ArrayList<String> stock3 = new ArrayList<>();
        stock3.add("Pico");
        stock3.add("Pico");
        stock3.add("Espada");
        stock3.add("Carne");
        stock3.add("Huevos");

        ciudadItemsStock.put("Jerez",stock1);
        ciudadItemsStock.put("Cadiz",stock2);
        ciudadItemsStock.put("Sevilla", stock3);

        //mostramos los precios base
        System.out.println("Precio productos base");
        for (String item : preciosItems.keySet()) {
        System.out.println("Precio "+ item +": " + preciosItems.get(item));


        }
        //aplicamos el metodo
        aplicarImpuestoLujo("Jerez", preciosItems, ciudadItemsStock);
        aplicarImpuestoLujo("Cadiz", preciosItems, ciudadItemsStock);
        aplicarImpuestoLujo("Sevilla", preciosItems, ciudadItemsStock);
    }

    //Escribe un metodo que reciba el nombre de una ciudad. Si la ciudad tiene más de 5 items en stock, aplica
    //un "impuesto de lujo" aumentando un 10% el precio de sus items en el mapa de precios base solo para esa transacción.

    public void aplicarImpuestoLujo(String ciudad, HashMap<String, Double> precioItems, HashMap<String, ArrayList<String>> ciudadItemsStock){
    //lista de productos de una ciudad
        ArrayList<String> stock = ciudadItemsStock.get(ciudad);

        //para contar los items:
        int cantidad = stock.size();

        //Creo un hashMap para guardar el precio con impuestos
        HashMap<String, Double> precioImpuestos = new HashMap<>();

        //recorremos los productos
        for (String item : stock){
            //obtenemos el precio de cada producto
            double precioBase = precioItems.get(item);

            //Si la ciudad tiene más de 5 items le aplicamos el impuesto
            if (cantidad > 5){
                //aplicamos el 10% de descuento
                precioBase =precioBase*1.10;
            }

            //Guardamos el precio
            precioImpuestos.put(item, precioBase);
        }
        //Mostramos los precios
        System.out.println("Precios para " + ciudad + ":");
        for (String item : precioImpuestos.keySet()) {
            System.out.println("Precio "+ item +": " + precioImpuestos.get(item));

        }
        System.out.println("------------------------------------");
    }
}

