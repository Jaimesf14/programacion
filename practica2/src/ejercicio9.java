import java.util.Scanner;

public class ejercicio9 {
    public static void main(String[] args) {
        //Crea un programa en Java que:
        //1. Pida al usuario por teclado 10 números enteros y los guarde en un array.
        //2. Recorra el array para encontrar:
        //- El valor máximo y la posición en la que aparece.
        //- El valor mínimo y la posición en la que aparece.
        Scanner s = new Scanner(System.in);
        System.out.println("introduce 10 números:");

        int[] array = new int[10];
        int menor =  array[0];
        int mayor =  array[0];
        int posmayor = 0;
        int posmenor = 0;
        for (int i = 0; i< array.length; i++) {
            array[i] = s.nextInt();
        }
        for (int i = 0; i< array.length; i++) {
            if (array[i] < menor) {
                menor = array[i];
                posmenor = i;
            } else if (array[i] > mayor) {
                mayor = array[i];
                posmayor = i;

            }
        }
        System.out.println("Valor máximo: " + mayor + " en la posición " + posmayor);
        System.out.println("Valor mínimo: " + menor + " en la posición " + posmenor);
    }
}
