package rpg.ui;

import rpg.exception.NivelInsuficienteException;

import java.util.Scanner;

public class Menus {
    private Scanner s = new Scanner(System.in);
    private MenuPersonaje menuPersonaje = new MenuPersonaje();
    private MenuViaje menuViaje = new MenuViaje();
    private MenuCompraItems menuCompraItems = new MenuCompraItems();
    private MenuEstadisticas menuEstadisticas = new MenuEstadisticas();
    private MenuEventos menuEventos = new MenuEventos();


    public void cargarMenus() {
        int eleccion = 0;
        do{
            System.out.println("--- MENU PRINCIPAL ---");
            System.out.println("| 1. Crear personaje");
            System.out.println("| 2. Cambiar de ciudad");
            System.out.println("| 3. Tienda");
            System.out.println("| 4. Estadisticas");
            System.out.println("| 5. Impuestos");
            System.out.println("| 6. Salir");
            System.out.println("Elige una opcion: ");
            eleccion = s.nextInt();
            switch (eleccion) {
                case 1 -> menuPersonaje.crearPersonaje();
                case 2 -> menuViaje.viajarCiudad();
                case 3 -> menuCompraItems.comprarItem();
                case 4 -> menuEstadisticas.menuEstadisticas();
                case 5 -> menuEventos.cobroImpuestos();
            }

        } while (eleccion != 6);


    }
}
