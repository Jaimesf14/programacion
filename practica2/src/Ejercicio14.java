import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio14 {
    //Crea un programa que:
    //Cree una lista de Strings (ArrayList<String>).
    //Pida al usuario nombres por teclado hasta que introduzca la palabra "fin".
    //Luego pida un nombre a buscar y diga si está en la lista o no, mostrando también en qué
    // posición se encuentra si existe.
    public static void main(String[] args) {
        //Cree una lista de Strings (ArrayList<String>).
        ArrayList<String> lista = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        String nombres;

        do {
            System.out.println("Introduce un nombre (cuando acabe introduzca fin");
            nombres =s.nextLine();

        }
    }

}

