import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio13 {
    //Crea un programa que:
    //Cree una lista de enteros (ArrayList<Integer>).
    //Pida números por teclado hasta que el usuario introduzca un número negativo (ese no se añade).
    //Muestre por pantalla todos los números de la lista y la suma total de los mismos.
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //Cree una lista de enteros (ArrayList<Integer>).
        ArrayList<Integer> lista = new ArrayList<>();
        int numeros;
        //Pida números por teclado hasta que el usuario introduzca un número negativo
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
                //Muestre por pantalla todos los números de la lista y la suma total de los mismos.
            }
            System.out.println("Números introducidos: " + lista);
            System.out.println("Suma total: " + suma);
    }
}

