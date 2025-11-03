public class ejercicio1 {
    public static void main (String[] args){
        //Define un array de números tipo double de 3 filas por 7 columnas con nombre doub y asigna los valores según
        // la siguiente tabla. Muestra el contenido de todos los elementos del array dispuestos en forma de tabla
        // como se muestra en la figura.
        //Definimos el array de tipo double, y ponermos el numero 1.5 para sustituirlo por un espacio.
      double numeros [][] = {
              {0,30,2,1.5,1.5,5},
              {75,1.5,1.5,1.5,0,1.5},
              {1.5,1.5,-2,9,1.5,11}
      };
      //Imprimimos la primera fila
        System.out.println("------------------------------------------------------------------------------");
      System.out.println("|Array num |Columna 0 |Columna 1 |Columna 2 |Columna 3 |Columna 4 |Columna 5 |");
      //Recorremos el array un bucle con la variable i(recorre las filas)
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("|----------+----------+----------+----------+----------+----------+----------|");
            //Imprimimos el "indice" de las filas
            System.out.print("|Fila " + i + "    |");
            //Recorremos el array con un bucle con la variable j(recorre las columnas) dentro del bucle anterior, para que dentro
            // de cada fila se rellenen las columnas, y cada vez que se rellenen las columnas de una fila salte a la
            // siguiente fila
            for (int j = 0; j < numeros[i].length; j++) {
                //Sustituyte el 1.5 por un espacio
                if (numeros[i][j] == 1.5){
                    System.out.print("          |");
                    //si no hay 1.5 imprime los numeros normales. El println lo utilizamos de modo de plantilla,
                    // que en este caso lo que hace el %9 es que se cree 9 espacios y acontinuacion se ponga el numero
                    // (si fuera %-9 el numero iria primero y los espacios a la derecha)
                } else {
                    System.out.printf("%9.0f |", numeros[i][j]);
                }
            }
            System.out.println(" ");
        }
        System.out.println("------------------------------------------------------------------------------");
    }
}
