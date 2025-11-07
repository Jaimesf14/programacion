import java.util.Random;
import java.util.Scanner;

public class ejercicio4 {
    //Modifica el programa anterior de tal forma que las sumas parciales y la suma total aparezcan en la pantalla con
    // un pequeño retraso, dando la impresión de que el ordenador se queda “pensando” antes de mostrar los números.
    public static void main(String[] args) throws InterruptedException {
        Random numaleatorio = new Random();

        int[][] numeros = new int[4][5];

        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                numeros[i][j] = numaleatorio.nextInt(1999) + 1;

            }
        }

        int sumatotal = 0;
        System.out.println("----------------------------------------------------------------------------------------------");
        for (int i = 0; i < numeros.length; i++) {
            int sumafila = 0;
            for (int j = 0; j < numeros[i].length; j++) {

                sumafila += numeros[i][j];
                System.out.printf("| %-13d", numeros[i][j]);


            }
            //Ponemos el thread.sleep(1000), para que aparezca un retraso de 1 seg en la suma de las filas.
            Thread.sleep(1000);
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


        }
        //Ponemos el thread.sleep(1000), para que aparezca un retraso de 1 seg en la suma total.
        Thread.sleep(1000);
        System.out.println("|Suma total: "+ sumatotal+"|");
        System.out.print("----------------------------------------------------------------------------------------------");
    }
}
