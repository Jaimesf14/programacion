import java.util.Scanner;

public class ejercicio7 {
    public static void main(String[] args) {
        //Programa Java que llene un array con 10 números enteros que se leen por teclado.
        // A continuación calcula y muestra la media de los valores positivos y la de los valores negativos del array.

                Scanner s = new Scanner(System.in);
        System.out.println("Introduce 10 números:");

        int[] array = new int[10];
        int numpos = 0;
        int numneg = 0;
        int sumapositivos = 0;
        double mediapositivos = 0;
        int sumanegativos = 0;
        double medianegativos = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = s.nextInt();
        }
        for (int i = 0; i < array.length; i++) {
            // A continuación calcula y muestra la media de los valores positivos
            if (array[i] > 0) {
                sumapositivos = sumapositivos + array[i];
                numpos++;
                // A continuación calcula y muestra la media de los valores negativos
            } else if (array[i] < 0){
                sumanegativos = sumanegativos + array[i];
                numneg++;
            }
            mediapositivos = (double) sumapositivos / numpos;
            medianegativos = (double) sumanegativos / numneg;
        }
        System.out.println("Resultado media valores positivos: " + mediapositivos);
        System.out.println("Resultado media valores negativos: " + medianegativos);
    }
}
