package rpg.ui;


import rpg.dao.*;
import rpg.exception.FondosInsuficientesException;
import rpg.exception.NivelInsuficienteException;
import rpg.logic.GestionMundo;
import rpg.logic.MotorCombate;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Menus {
    private Scanner s =new Scanner(System.in);
    private GestionMundo gestionMundo = new GestionMundo(new ItemsDAO(), new HabilidadesDAO(), new RazasDAO(), new ClasesRPGDAO(), new CiudadesDAO());
    private MotorCombate motorCombate = new MotorCombate(new ItemsDAO(), new HabilidadesDAO(), new RazasDAO(), new ClasesRPGDAO(), new CiudadesDAO());
    public Menus() {

    }

    public void cargarMenus() throws NivelInsuficienteException, FondosInsuficientesException {
        int eleccion = 0;
        do{
            System.out.println("======== MENU ========");
            System.out.println("| 1. Crear personaje");
            System.out.println("| 2. Cambiar de ciudad");
            System.out.println("| 3. Tienda");
            System.out.println("| 4. Cobro de impuestos");
            System.out.println("| 5. Censo de clases");
            System.out.println("| 6. Jugadores más ricos");
            System.out.println("| 7. Eleccion de habilidades");
            System.out.println("| 8. Combate");
            System.out.println("| 9. Salir");
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
                case 4 -> gestionMundo.cobroImpuestos();
                case 5 -> gestionMundo.censoClases();
                case 6 -> gestionMundo.jugadoresMasRicos();
                case 7 -> motorCombate.eleccionHabilidades();
               // case 8 -> ;

            }
        } while (eleccion != 9);
    }
}



