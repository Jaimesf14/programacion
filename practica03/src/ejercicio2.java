import java.awt.datatransfer.SystemFlavorMap;
import java.util.Scanner;

public class ejercicio2 {
    //Escribe un programa que solicite 20 números enteros. Estos números debemos de introducirlo en un array de 4 filas
    // por 5 columnas. El programa mostrará las sumas parciales de filas y en las columnas el mayor número de la columna.
    // La suma total debe aparecer en la esquina inferior derecha.

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //solicitamos 20 numeros enteros
        System.out.println("introduce 20 número:");
        //Definimos el array de 4 filas y 5 columnas
        int[][] numeros = new int[4][5];
        //Recorremos el array para que se escriban los numeros
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                numeros[i][j] = s.nextInt();

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
        //Definimos la variable sumaTotal
        int sumatotal = 0;
        System.out.println("----------------------------------------------------------------------------------");
        //Definimos dentro de un bucle la variable sumafila, y le vamos sumando los numeros cuando recorra las columnas del array
        for (int i = 0; i < numeros.length; i++) {
            int sumafila = 0;
            for (int j = 0; j < numeros[i].length; j++) {

                sumafila += numeros[i][j];
                System.out.printf("| %-11d", numeros[i][j]);

                //Imprimimos la suma de las filas
            }
            System.out.print("|Fila " + i + ": " + sumafila + "     |");
            System.out.println(" ");
            System.out.println("|------------+------------+------------+------------+------------+---------------|");
            //A la variable suma total se suma todas las sumas de las filas.
            sumatotal += sumafila;

        }
        //Recorremos el array para calcular el mayor de cada columna. Ponemos numero[0] para referirse a la primela fila del array.
        for (int j = 0; j < numeros[0].length; j++) {
            int mayorcolumna = numeros[0][j];
            //Una vez definida la variable mayorcolumna recorremos la i para que vaya comparando los numeros con el mayor de la columna, y seleccione el mayor.
            for (int i = 0; i < numeros.length; i++) {
                if (numeros[i][j] > mayorcolumna) {
                    mayorcolumna = numeros[i][j];
                }
            }

            System.out.printf("|Columna" + j +": "+ mayorcolumna);


        } System.out.println("|Suma total: "+ sumatotal+"|");
        System.out.print("----------------------------------------------------------------------------------");
    }
}


