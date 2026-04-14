package rpg.ui;

import rpg.dao.ClasesDAO;
import rpg.dao.PersonajeDAO;
import rpg.dao.RazasDAO;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class MenuPersonaje {
    private Scanner s = new Scanner(System.in);
    private PersonajeDAO personajeDAO = new PersonajeDAO();
    private ClasesDAO clasesDAO = new ClasesDAO();
    private RazasDAO razasDAO = new RazasDAO();

    public void crearPersonaje(){
        System.out.println("--- CREAR PERSONAJE ---");
        System.out.println("Nombre: ");
        String nombre = s.nextLine();

        List<String> razas = razasDAO.listaRazas();
        System.out.println("Selecciona la ID de una raza: ");
        for (String r: razas){
            System.out.println(r);
        }
        int razaId = s.nextInt();

        List<String> clases = clasesDAO.listaClases();
        System.out.println("Selecciona la ID de una clase: ");
        for (String c: clases){
            System.out.println(c);
        }
        int claseId = s.nextInt();

        personajeDAO.crearPersonaje(nombre, razaId, claseId);

        System.out.println("Se ha creado el personaje correctamente");


    }
}
