import java.util.Random;
import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        /*
        Crear un programa que cuando se le introduzca números enteros rellene un array de 6 filas por 10 columnas con
        números enteros positivos comprendidos entre 0 y 1000 (ambos incluidos). A continuación, el programa deberá:
        dar la posición del número máximo y mínimo
        la suma total de todas las filas y columnas
        la suma de todas las columnas
        la suma de todas las filas.
        */
        Random numaleatorio = new Random();

        int[][] numeros = new int[6][10];

        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                numeros[i][j] = numaleatorio.nextInt(1001);

            }
        }

        int sumatotal = 0;
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < numeros.length; i++) {
            int sumafila = 0;
            for (int j = 0; j < numeros[i].length; j++) {

                sumafila += numeros[i][j];
                System.out.printf("| %-13d", numeros[i][j]);


            }
            System.out.print("|Fila " + i + ": " + sumafila + "     |");
            System.out.println(" ");
            System.out.println("|--------------+--------------+--------------+--------------+--------------+--------------+--------------+--------------+--------------+--------------+------------------");
            sumatotal += sumafila;

        }

        for (int j = 0; j < numeros[0].length; j++) {
            int sumacolumna = numeros[0][j];
            for (int i = 0; i < numeros.length; i++) {
                sumacolumna += numeros[i][j];
            }

            System.out.printf("|Columna" + j + ": " + sumacolumna);
            sumatotal += sumacolumna;
        }
        System.out.println("|Suma total: " + sumatotal + "|");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        int menor = numeros[0][0];
        int mayor = numeros[0][0];
        int posmayorfila = 0;
        int posmayorcol = 0;
        int posmenorfila = 0;
        int posmenorcol = 0;

        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                if (numeros[i][j] < menor) {
                    menor = numeros[i][j];
                    posmenorfila = i;
                    posmenorcol = j;
                } else if (numeros[i][j] > mayor) {
                    mayor = numeros[i][j];
                    posmayorfila = i;
                    posmayorcol = j;

                }

            }

        }
        System.out.println("Valor máximo: " + mayor + " en la posición [" + posmayorfila + "][" + posmayorcol + "]");
        System.out.println("Valor mínimo: " + menor + " en la posición [" + posmenorfila + "][" + posmenorcol + "]");
    }
}




