import java.util.Scanner;

public class ejercicio6 {
    public static void main(String[] args) {
        //Programa Java que guarda en un array 10 números enteros que se leen por teclado.
        // A continuación se recorre el array y calcula cuántos números son positivos,
        // cuántos negativos y cuántos ceros.
        //Programa Java que guarda en un array 10 números enteros que se leen por teclado.
        Scanner s = new Scanner(System.in);
        System.out.println("Introduce 10 números:");

        int[] array = new int[10];
        int positivos = 0;
        int negativos = 0;
        int ceros = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = s.nextInt();
        }
        for (int i = 0; i < array.length; i++) {
            //calcula cuántos números son positivos
            if (array[i] > 0) {
                positivos++;
                //calcula cuántos números son negativos
            } else if (array[i] < 0) {
                negativos++;
               // calcula cuántos números son ceros
            } else {
                ceros++;
            }
        }
        System.out.println("Hay " + positivos + " números positivos, hay " + negativos + " números negativos, y hay " + ceros + " números cero.");
    }
}
