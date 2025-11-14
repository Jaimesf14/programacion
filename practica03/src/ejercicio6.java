import java.util.Random;

public class ejercicio6 {
    public static void main(String[] args) {
        /*
        Modifica el programa anterior de tal forma que no se repita ningún número en el array además de que tiene
        que estar comprendido en un rango entre 20-40.
        */
        Random numaleatorio = new Random();

        int[][] numeros = new int[6][10];
        int[] auxiliar = new int[21];
        //se rellena el array axiliar con los numeros del 20 al 40
        for (int i = 0; i < auxiliar.length; i++) {
                auxiliar[i] = 20 + i;
        }
        //Ahora a traves de los bucles y la variable temp se mezclan los valores, sin que se repita ninguno. El int
        // temp se usa para intercambiar (swap) los valores de dos posiciones del array sin perder ninguno.
        //Esto forma parte del algoritmo de mezcla aleatoria
        for (int i = 0; i < auxiliar.length; i++) {
            int j = numaleatorio.nextInt(auxiliar.length);
            int temp = auxiliar[i];
            auxiliar[i] = auxiliar[j];
            auxiliar[j] = temp;
        }
        // rellenamos el array con los numeros. Para ello nos ayudamos de un indice.
        int indice = 0;
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                if(indice < auxiliar.length){
                    numeros[i][j] = auxiliar[indice];
                    indice++;
                    //Una vez rellenado el array con todos los numeros posibles, declaramos que el resto del array se
                    // rellenará con 0.
                } else {
                    numeros[i][j] = 0;
                }
            }
        }


        int sumatotal = 0;
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < numeros.length; i++) {
            int sumafila = 0;
            for (int j = 0; j < numeros[i].length; j++) {
                sumafila += numeros[i][j];
                //Sustituimos los 0 por espacios.
                if (numeros[i][j] == 0) {
                    System.out.printf("| %-13s", " ");
                } else {
                    System.out.printf("| %-13d", numeros[i][j]);

                }
            }
            System.out.print("|Fila " + i + ": " + sumafila + "     |");
            System.out.println(" ");
            System.out.println("|--------------+--------------+--------------+--------------+--------------+--------------+--------------+--------------+--------------+--------------+-----------------");
            sumatotal += sumafila;

        }

        for (int j = 0; j < numeros[0].length; j++) {
            int sumacolumna = 0;
            for (int i = 0; i < numeros.length; i++) {
                sumacolumna += numeros[i][j];
            }

            System.out.printf("|Columna" + j + ":   " + sumacolumna);
            sumatotal += sumacolumna;
        }
        System.out.println("|Suma total: " + sumatotal + "|");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

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



