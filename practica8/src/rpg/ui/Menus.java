package rpg.ui;


import rpg.dao.*;
import rpg.exception.FondosInsuficientesException;
import rpg.exception.NivelInsuficienteException;
import rpg.logic.GestionMundo;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Menus {
    private Scanner s =new Scanner(System.in);
    private GestionMundo gestionMundo = new GestionMundo(new ItemsDAO(), new HabilidadesDAO(), new RazasDAO(), new ClasesRPGDAO(), new CiudadesDAO());
    public Menus() {

    }

    public void cargarMenus() throws NivelInsuficienteException, FondosInsuficientesException {
        int eleccion = 0;
        do{
            System.out.println("======== MENU ========");
            System.out.println("| 1. Crear personaje");
            System.out.println("| 2. Cambiar de ciudad");
            System.out.println("| 3. Tienda");
            System.out.println("| 4. Estadisticas");
            System.out.println("| 5. Impuestos");
            System.out.println("| 6. Salir");
            System.out.println("======================");
            System.out.println("Elige una opcion: ");
            eleccion = s.nextInt();

            switch (eleccion){
                case 1 -> gestionMundo.crearPersonaje();
                case 2 -> {
                    try{
                        gestionMundo.viajarCiudad();
                    } catch (NivelInsuficienteException e){
                        System.out.println("Prueba con otro personaje de mas nivel o con otra ciudad de menos nivel");
                    }
                }
                case 3 -> gestionMundo.tienda();

            }
        } while (eleccion != 6);
    }
}



