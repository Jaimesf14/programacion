import rpg.dao.*;
import rpg.logic.GestionMundo;
import rpg.model.ClasesRPG;
import rpg.ui.Menus;

public static void main(String[] args){
    /*System.out.println("RAZAS");
    RazasDAO razasDAO = new RazasDAO();
    System.out.println("CLASES");
    ClasesRPGDAO clasesRPGDAO = new ClasesRPGDAO();
    System.out.println("CIUDADES");
    CiudadesDAO ciudadesDAO = new CiudadesDAO();
    System.out.println("ITEMS");
    ItemsDAO itemsDAO = new ItemsDAO();
    System.out.println("HABILIDADES");
    HabilidadesDAO habilidadesDAO = new HabilidadesDAO();
    System.out.println("PERSONAJES");
    itemsDAO.cargarItems();
    PersonajesDAO personajesDAO = new PersonajesDAO(itemsDAO, habilidadesDAO, razasDAO, clasesRPGDAO, ciudadesDAO);
    GestionMundo gestionMundo = new GestionMundo();*/
    Menus menus = new Menus();
    menus.cargarMenus();

    /*personajesDAO.cargarPersonajes();
    razasDAO.getLista_razas();
    clasesRPGDAO.getLista_clases();
    ciudadesDAO.getLista_ciudades();
    itemsDAO.getLista_items();
    habilidadesDAO.getLista_habilidades();
    personajesDAO.getLista_personajes();*/
}
