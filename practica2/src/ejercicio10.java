import java.util.Scanner;

public class ejercicio10 {
    public static void main(String[] args) {
        //Crea un programa que muestre por pantalla la nota de un estudiante, de entre una lista de estudiantes c
        // on sus respectivas notas. El nombre del estudiante lo introduce el usuario por teclado
        // (usa la clase Scanner). Utiliza un array para los nombres de los alumnos y otro para las notas.
        // ¿Serías capaz de hacerlo con un array BIdimensional?
            Scanner s = new Scanner(System.in);
            //Lista de estudiantes con sus respectivas notas.
            String[] nombres = {"Manuel","Jesus","Maria","Jaime","Julia"};
            double[] notas = {6.7,7,8.5,5,9};
            String estudiante;
            int ultimoEst= nombres.length - 1;
            //Introduce el  nombre del estudiante
            System.out.println("Dime el nombre de un estudiante: ");
            estudiante = s.nextLine();
            for (int i = 0; i < nombres.length; i++) {
                if (estudiante.equals(nombres[i])) {
                    System.out.println("La nota del estudiante es: " + nombres[i] + " " + notas[i]);
                    break;
                    //Muestra otro mensaje si el estudiante no está en la lista
                } else if (i == ultimoEst && !estudiante.equals(nombres[i])) {
                    System.out.println("Ese estudiante no  está inscrito");
                    break;
                }
            }

    }
}
