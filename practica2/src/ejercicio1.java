import java.util.Scanner;

public class ejercicio1 {

    //Crea un array de 10 posiciones de números con valores pedidos
    // por teclado. Muestra por consola el índice y el valor al que
    // corresponde.
    public static void main (String[] args){
        //Crea un array de 10 posiciones de números con valores pedidos por teclado.
        Scanner sc =  new Scanner(System.in);
        int[] arrayInt = new int[10];

        System.out.println("introduce otro número:");
        for(int i=0; i<10;){
            int valor = sc.nextInt();

    //Muestra por consola el índice y el valor al que corresponde.
            System.out.println("indice " + i++ + " = al valor " + valor);


        }
    }
}
