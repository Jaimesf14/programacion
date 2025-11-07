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
        //Generamos la variable numaleatorio, con numeros aleatorios.
        Random numaleatorio = new Random();
        //Definimos el array de 6 filas y 10 columnas
        int[][] numeros = new int[6][10];
        //Recorremos el bucle donde rellenamos el array con numeros aleatorios del 0 al 1000
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                numeros[i][j] = numaleatorio.nextInt(1001);

            }
        }
        //Igual que ejercicios anteriores.
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
        //Calculamos la suma de las columnas recorriendo el array, empezando por la j(columnas). En el bucle de i sera donde a la variable sumacolumna (definida en bucle j) le iremos sumando los numeros de cada columna.
        for (int j = 0; j < numeros[0].length; j++) {
            int sumacolumna = 0;
            for (int i = 0; i < numeros.length; i++) {
                sumacolumna += numeros[i][j];
            }
            //Imprimimos la suma de las columnas
            System.out.printf("|Columna" + j + ": " + sumacolumna);
            //A la suma totalle sumamos las sumas de las columnas.
            sumatotal += sumacolumna;
        }
        //Imprimimos la suma total
        System.out.println("|Suma total: " + sumatotal + "|");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        //Definimos las variables necesarias para calcular en numero menor y mayor y sus respectivas posiciones
        int menor = numeros[0][0];
        int mayor = numeros[0][0];
        int posmayorfila = 0;
        int posmayorcol = 0;
        int posmenorfila = 0;
        int posmenorcol = 0;
        //Recoremos el array
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                //definimos que si un numero es menor que la variable menor, se asigne a la variable ese numero,
                // las variables pos se quedan con la posicion, ya sea fila o columna, del numero elegido como menor
                if (numeros[i][j] < menor) {
                    menor = numeros[i][j];
                    posmenorfila = i;
                    posmenorcol = j;
                    //definimos que si un numero es mayor que la variable mayor, se asigne a la variable ese numero,
                    // las variables pos se quedan con la posicion, ya sea fila o columna, del numero elegido como mayor
                } else if (numeros[i][j] > mayor) {
                    mayor = numeros[i][j];
                    posmayorfila = i;
                    posmayorcol = j;

                }

            }

        }
        //Imprimimos los valores mayor y menor y sus respectivas posiciones.
        System.out.println("Valor máximo: " + mayor + " en la posición [" + posmayorfila + "][" + posmayorcol + "]");
        System.out.println("Valor mínimo: " + menor + " en la posición [" + posmenorfila + "][" + posmenorcol + "]");
    }
}




