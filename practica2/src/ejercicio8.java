import java.util.Scanner;

public class ejercicio8 {
    public static void main(String[] args) {
        //Programa Java para leer la altura de N personas y calcular la altura media.
        // Calcular cuántas personas tienen una altura superior a la media y
        // cuántas tienen una altura inferior a la media. El valor de N se pide por teclado
        // y debe ser entero positivo.
        Scanner s = new Scanner(System.in);
        //Programa Java para leer la altura de N personas
        int num;
        do {
            System.out.println("Introduce el número de porsonas con las que quieres hacer media: ");
            num = s.nextInt();
        } while (num <= 0);
        double[] alturas = new double[num];
        double suma = 0;
        for (int i = 0; i < num; i++) {
            System.out.println("Ingrese la altura de la persona " + (i + 1) + " en metros");
            alturas[i] = s.nextDouble();
            suma += alturas[i];
        }
        //calcular la altura media.
        double media = suma / num;
        int superior = 0;
        int inferior = 0;
        // Calcular cuántas personas tienen una altura superior a la media y
        //cuántas tienen una altura inferior a la media.
        for (int i = 0;i < num; i++) {
            if (alturas[i] > media){
                superior++;
            } else {
                inferior++;
            }
        }
        System.out.println("Altura media: " + media);
        System.out.println("Personas con altura superior a la media: " + superior);
        System.out.println("Personas con altura superior a la media: " + inferior);
    }
}