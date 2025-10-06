import java.util.Scanner;

public class ejercicio1 {

    //Crea un array de 10 posiciones de números con valores pedidos
    // por teclado. Muestra por consola el índice y el valor al que
    // corresponde.
    public static void main(String[] args) {
        //Crea un array de 10 posiciones de números con valores pedidos por teclado.
        Scanner sc = new Scanner(System.in);
        System.out.println("introduce otro número:");
        int[] arrayInt = new int[10];
        for (int i = 0; i< arrayInt.length; i++) {

            arrayInt[i] = sc.nextInt();
        }
            //Muestra por consola el índice y el valor al que corresponde.
        for (int i = 0; i < arrayInt.length; i++) {
            System.out.println("indice " + i + " --> " + arrayInt[i]);
        }
    }
}



