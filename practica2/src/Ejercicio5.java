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
        int suma = 0;
        int[] array = new int[tamaño];
        //rellenaremos el array con números aleatorios entre 0 y 9
        for (int i = 0; i< array.length; i++) {
            array[i] = (int)(Math.random()*10);
            //Muestra por pantalla el valor de cada posición
            System.out.println("Indice " + i + "--> " + array[i] + " ");
            //Calculamos la suma
            suma = suma + array[i];

        }//Muestra por pantalla el resultado de la suma de todos los valor
        System.out.println("Resultado de la suma de todos los valores: " + suma);
    }
}