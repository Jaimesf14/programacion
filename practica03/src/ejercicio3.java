import java.util.Random;
import java.util.Scanner;

public class ejercicio3 {
    //Modifica el programa anterior de tal forma que los números que se introducen en el array se generen de forma aleatoria (valores entre 1 y 1999).
    public static void main(String[] args) {
        //Generamos la variable numaleatorio, con numeros aleatorios.
        Random numaleatorio = new Random();
        //Definimos el array
        int[][] numeros = new int[4][5];
        //recorremos el bucle y definimos que queremos numeros aleatorios entre 1 y 2000
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                numeros[i][j] = numaleatorio.nextInt(1999) + 1;

            }
        }
        //El resto es igual que el ejercicio anterior.
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

