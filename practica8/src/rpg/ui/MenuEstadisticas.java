package rpg.ui;

import rpg.logic.Estadisticas;

import java.util.Scanner;

public class MenuEstadisticas {
    private Scanner s = new Scanner(System.in);
    private Estadisticas estadisticas = new Estadisticas();


    public void menuEstadisticas(){
        int eleccion = 0;
        do{
            System.out.println("--- MENU ESTADISTICAS ---");
            System.out.println("| 1. Jugadores más ricos");
            System.out.println("| 2. Censo de clases");
            System.out.println("| 3. Salir");
            System.out.println("Elige una opcion: ");
            eleccion = s.nextInt();


            switch (eleccion) {
                case 1 -> estadisticas.topRicos();
                case 2 -> estadisticas.censoClases();
                case 3 -> {
                    return;
                }
            }

        } while (eleccion != 3);
    }
}
