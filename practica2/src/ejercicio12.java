import java.util.Scanner;

public class ejercicio12 {
    //En España cada persona está identificada con un Documento Nacional de Identidad (DNI) en el que figura un
    // número y una letra, por ejemplo 56999545W. Realiza un programa donde le pidas al usuario SOLO el número del dni
    // y el programa te devuelva la letra. Para calcular la letra solo tienes que dividir el número del DNI entre 23,
    // el resto de esta división se corresponde con la posición de la letra en el abecedario. Utiliza un array para
    // guardar CADA letra del abecedario.
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //posicion de las letras
        String[] letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V",
                "H", "L", "C", "K", "E"};
        //Introducir el numero del Dni
        System.out.print("Introduce tu número de DNI (sin letra): ");
        int numeroDni = s.nextInt();
        //Division para calcular la letra
        int posicion = numeroDni % 23;
        String letraDni = letras[posicion];
        //Imprime la letra
        System.out.println("La letra del Dni es: " + letraDni);

    }
}
