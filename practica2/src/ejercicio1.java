import java.util.Scanner;

public class ejercicio1 {

    //Crea un array de 10 posiciones de números con valores pedidos por teclado.
    // Muestra por consola el índice y el valor al que corresponde.
    public static void main(String[] args) {
        //Crea un array de 10 posiciones de números con valores pedidos por teclado.
        Scanner s = new Scanner(System.in);
        System.out.println("introduce 10 número:");

        int[] array = new int[10];
        for (int i = 0; i< array.length; i++) {
            array[i] = s.nextInt();
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println("indice " + i + " --> " + array[i]);
        }
    }
}



