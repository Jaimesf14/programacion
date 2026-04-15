package rpg.ui;

import rpg.logic.Estadisticas;

import java.util.Scanner;

public class MenuEstadisticas {
    private Scanner s = new Scanner(System.in);
    private Estadisticas estadisticas = new Estadisticas();
    private Menus menu = new Menus();

    public void menuEstadisticas(){
        int eleccion = 0;
        while (true){
            System.out.println("--- MENU ESTADISTICAS ---");
            System.out.println("| 1. Jugadores más ricos");
            System.out.println("| 2. Censo de clases");
            System.out.println("| 3. Salir");
            System.out.println("Elige una opcion: ");
            eleccion = s.nextInt();

            if (eleccion == 1){

            } else if (eleccion == 2) {
                estadisticas.censoClases();
            } else if (eleccion == 3) {
                menu.cargarMenus();
            }
        }
    }
}
