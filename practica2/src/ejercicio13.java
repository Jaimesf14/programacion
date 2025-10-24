import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio13 {
    //Crea un programa que:
    //Cree una lista de enteros (ArrayList<Integer>).
    //Pida números por teclado hasta que el usuario introduzca un número negativo (ese no se añade).
    //Muestre por pantalla todos los números de la lista y la suma total de los mismos.
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();
        int numeros;
        do {
        System.out.println("Introduzca un número por teclado (cuando sea negativo se parará)");
        numeros = s.nextInt();
        if (numeros >= 0){
            lista.add(numeros);
            }
        } while (numeros >= 0);
            int suma= 0;
            for (int integer : lista) {
                suma += integer;

            }
            System.out.println("Números introducidos: " + numeros);
            System.out.println("Suma total: " + suma);
    }
}


