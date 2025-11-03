public class ejercicio1 {
    public static void main (String[] args){
      double numeros [][] = {
              {0,30,2,1.5,1.5,5},
              {75,1.5,1.5,1.5,0,1.5},
              {1.5,1.5,-2,9,1.5,11}
      };
        System.out.println("------------------------------------------------------------------------------");
      System.out.println("|Array num |Columna 0 |Columna 1 |Columna 2 |Columna 3 |Columna 4 |Columna 5 |");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("|----------+----------+----------+----------+----------+----------+----------|");
            System.out.print("|Fila " + i + "    |");
            for (int j = 0; j < numeros[i].length; j++) {
                if (numeros[i][j] == 1.5){
                    System.out.print("          |");
                } else {
                    System.out.printf("%9.0f |", numeros[i][j]);
                }
            }
            System.out.println(" ");
        }
        System.out.println("------------------------------------------------------------------------------");
    }
}
