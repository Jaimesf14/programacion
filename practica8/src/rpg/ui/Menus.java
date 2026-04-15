package rpg.ui;

import rpg.exception.NivelInsuficienteException;

import java.util.Scanner;

public class Menus {
    private Scanner s = new Scanner(System.in);
    private MenuPersonaje menuPersonaje = new MenuPersonaje();
    private MenuViaje menuViaje = new MenuViaje();
    private MenuCompraItems menuCompraItems = new MenuCompraItems();
    private MenuEstadisticas menuEstadisticas = new MenuEstadisticas();


    public void cargarMenus() {
        int eleccion = 0;
        while (eleccion != 5){
            System.out.println("--- MENU PRINCIPAL ---");
            System.out.println("| 1. Crear personaje");
            System.out.println("| 2. Cambiar de ciudad");
            System.out.println("| 3. Tienda");
            System.out.println("| 4. Estadisticas");
            System.out.println("| 5. Salir");
            System.out.println("Elige una opcion: ");
            eleccion = s.nextInt();
            if (eleccion == 1){
                menuPersonaje.crearPersonaje();
            } else if (eleccion == 2) {
                menuViaje.viajarCiudad();
            } else if (eleccion == 3) {
                menuCompraItems.comprarItem();
            } else if (eleccion == 4) {
                menuEstadisticas.menuEstadisticas();
            }
        }


    }
}
