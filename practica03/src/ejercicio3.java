import java.util.Random;
import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        Random numaleatorio = new Random();

        int[][] numeros = new int[4][5];

        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                numeros[i][j] = numaleatorio.nextInt(1999) + 1;

            }
        }
        /*
        int[][] numeros = {
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 10},
                {21, 22, 23, 14, 15},
                {16, 17, 18, 19, 20}
        };
        */

        int sumatotal = 0;
        System.out.println("----------------------------------------------------------------------------------------------");
        for (int i = 0; i < numeros.length; i++) {
            int sumafila = 0;
            for (int j = 0; j < numeros[i].length; j++) {

                sumafila += numeros[i][j];
                System.out.printf("| %-13d", numeros[i][j]);


            }
            System.out.print("|Fila " + i + ": " + sumafila + "     |");
            System.out.println(" ");
            System.out.println("|--------------+--------------+--------------+--------------+--------------+-----------------|");
            sumatotal += sumafila;

        }

        for (int j = 0; j < numeros[0].length; j++) {
            int mayorcolumna = numeros[0][j];

            for (int i = 0; i < numeros.length; i++) {
                if (numeros[i][j] > mayorcolumna) {
                    mayorcolumna = numeros[i][j];
                }
            }

            System.out.printf("|Columna" + j +": "+ mayorcolumna);


        } System.out.println("|Suma total: "+ sumatotal+"|");
        System.out.print("----------------------------------------------------------------------------------------------");
    }
}

