import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        //Crea un array que contenga 5 números. Realiza un programa que te muestre por pantalla SOLO el más
        //pequeño de ellos.

        int[] numero = {10, 25, 5, 32, 12};
        int menor =  numero[0];
        for (int i = 1; i < numero.length; i++)
            if (numero[i] < menor) {
         menor = numero[i];
        }
        System.out.println("El número más pequeño es: " + menor);
    }
}