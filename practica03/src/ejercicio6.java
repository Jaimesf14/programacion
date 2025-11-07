import java.util.Random;

public class ejercicio6 {
    public static void main(String[] args) {
        /*
        Modifica el programa anterior de tal forma que no se repita ningún número en el array además de que tiene
        que estar comprendido en un rango entre 20-40.
        */
        Random numaleatorio = new Random();

        int[][] numeros = new int[6][10];

        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                numeros[i][j] = numaleatorio.nextInt(40 - 20 + 1)+20;

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
            int sumacolumna = 0;
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

