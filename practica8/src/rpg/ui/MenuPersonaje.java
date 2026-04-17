package rpg.ui;

import rpg.dao.CiudadesDAO;
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
    private CiudadesDAO ciudadesDAO = new CiudadesDAO();

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

        List<String> ciudades = ciudadesDAO.listaCiudad();
        System.out.println("Selecciona la ID de una ciudad: ");
        for (String ci : ciudades){
            System.out.println(ci);
        }
        int ciudadId = s.nextInt();
        personajeDAO.crearPersonaje(nombre, razaId, claseId, ciudadId);

        System.out.println("Se ha creado el personaje correctamente");

    }
}
