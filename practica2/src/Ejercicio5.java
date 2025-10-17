import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        //Crea un array de números donde le indicamos por teclado el tamaño del array, rellenaremos
        // el array con números aleatorios entre 0 y 9, al final muestra por pantalla el valor de
        // cada posición y la suma de todos los valores.
        Scanner s = new Scanner(System.in);
        //Crea un array de números donde le indicamos por teclado el tamaño del array
        System.out.println("introduce un número para el tamaño del array:");
        int tamaño = s.nextInt();
        int[] array = new int[tamaño];
        for (int i = (int) (Math.random() * 10); i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}