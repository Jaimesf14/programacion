package rpg.ui;


import rpg.dao.*;
import rpg.logic.GestionMundo;

import java.util.Scanner;

public class Menus {
    private Scanner s =new Scanner(System.in);
    private GestionMundo gestionMundo = new GestionMundo(new ItemsDAO(), new HabilidadesDAO(), new RazasDAO(), new ClasesRPGDAO(), new CiudadesDAO());
    public Menus() {

    }

    public void cargarMenus(){
        System.out.println("cARGA DE MENU");
        gestionMundo.crearPersonaje();
    }
}



