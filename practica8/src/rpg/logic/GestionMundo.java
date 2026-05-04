package rpg.logic;

import rpg.dao.*;
import rpg.model.Ciudades;
import rpg.model.ClasesRPG;
import rpg.model.Personajes;
import rpg.model.Razas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionMundo {
    private Scanner s = new Scanner(System.in);
    private ItemsDAO itemsDAO;
    private HabilidadesDAO habilidadesDAO;
    private RazasDAO razasDAO;
    private ClasesRPGDAO clasesRPGDAO;
    private CiudadesDAO ciudadesDAO;
    private PersonajesDAO personajesDAO;


    public GestionMundo(ItemsDAO itemsDAO, HabilidadesDAO habilidadesDAO, RazasDAO razasDAO, ClasesRPGDAO clasesRPGDAO, CiudadesDAO ciudadesDAO) {
        this.itemsDAO = itemsDAO;
        this.habilidadesDAO = habilidadesDAO;
        this.razasDAO = razasDAO;
        this.clasesRPGDAO = clasesRPGDAO;
        this.ciudadesDAO = ciudadesDAO;
        this.personajesDAO = new PersonajesDAO(itemsDAO, habilidadesDAO, razasDAO, clasesRPGDAO, ciudadesDAO
        );
    }

    public void crearPersonaje(){
        try{
            System.out.println("===CREAR PERSONAJE===");

            //Nombre
            System.out.println("Nombre: ");
            String nombre = s.nextLine();

            //Raza
            razasDAO.cargarRazas();
            List<Razas> razas = razasDAO.getLista_razas();
            System.out.println("Selecciona el ID de la raza que desea: ");
            for (Razas r : razas){
                System.out.println("ID: " + r.getId() + " - " + r.getNombre() + " - Bonificador fuerza: " + r.getBonificador_fuerza() + " - Bonificador vida: " + r.getBonificador_vida());
            }
            int idRaza = s.nextInt();
            s.nextLine();
            Razas razaSeleccionada = razasDAO.buscarRazaPorId(idRaza);
            if (razaSeleccionada == null){
                System.out.println("Id de la raza no valido");
                return;
                //Pongo el return, para cortar el metodo ya que no existe el id, y asi no meta datos erroneos a la base de datos.
            }

            //Clase
            clasesRPGDAO.cargarClases();
            List<ClasesRPG> clases = clasesRPGDAO.getLista_clases();
            System.out.println("Selecciona el ID de la clase que desea: ");
            for (ClasesRPG  c : clases){
                System.out.println("ID: " + c.getId() + " - " + c.getNombre());
            }
            int idClase = s.nextInt();
            s.nextLine();
            ClasesRPG claseSeleccionada = clasesRPGDAO.buscarClasePorId(idClase);
            if (claseSeleccionada == null){
                System.out.println("Id de la clase no valido");
                return;
            }

            //Ciudad
            ciudadesDAO.cargarCiudades();
            List<Ciudades> ciudades = ciudadesDAO.getLista_ciudades();
            System.out.println("Selecciona el ID de la ciudad que desea: ");
            for (Ciudades c : ciudades){
                System.out.println("ID: " + c.getId() + " - " + c.getNombre() + " - " + c.getNivel_minimo_acceso());
            }
            int idCiudad = s.nextInt();
            s.nextLine();
            Ciudades ciudadSeleccionada = ciudadesDAO.buscarCiudadesPorId(idCiudad);
            if (ciudadSeleccionada == null){
                System.out.println("Id de la ciudad no valido");
                return;
            }
            s.nextLine();
            Personajes personaje = new Personajes(0,nombre,1,100,100,razaSeleccionada,claseSeleccionada,ciudadSeleccionada);
            personajesDAO.crearPersonajes(personaje);
            System.out.println("Personaje creado correctamente");

        } catch (Exception e) {
            System.out.println("Error al crear el personaje: " +  e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
