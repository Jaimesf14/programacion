package rpg.logic;

import rpg.dao.*;
import rpg.model.Habilidades;
import rpg.model.Personajes;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MotorCombate {
    private Scanner s = new Scanner(System.in);
    private ItemsDAO itemsDAO;
    private HabilidadesDAO habilidadesDAO;
    private RazasDAO razasDAO;
    private ClasesRPGDAO clasesRPGDAO;
    private CiudadesDAO ciudadesDAO;
    private PersonajesDAO personajesDAO;

    public MotorCombate(ItemsDAO itemsDAO, HabilidadesDAO habilidadesDAO, RazasDAO razasDAO, ClasesRPGDAO clasesRPGDAO, CiudadesDAO ciudadesDAO) {
        this.itemsDAO = itemsDAO;
        this.habilidadesDAO = habilidadesDAO;
        this.razasDAO = razasDAO;
        this.clasesRPGDAO = clasesRPGDAO;
        this.ciudadesDAO = ciudadesDAO;
        this.personajesDAO = new PersonajesDAO(itemsDAO, habilidadesDAO, razasDAO, clasesRPGDAO, ciudadesDAO);
    }

    //------------------------------------------------------------------------------------------------------------------

    public void eleccionHabilidades(){
        System.out.println("===ELECCION DE HABILIDADES===");
        personajesDAO.cargarPersonajes();
        List<Personajes>personajes = personajesDAO.getLista_personajes();
        System.out.println("Selecciona la id del personaje el cual quieres que elija habilidades: ");
        for (Personajes p : personajes){
            System.out.println("- ID: " + p.getId() + " - Nombre: " + p.getNombre());
        }

        int idPersonaje = s.nextInt();
        s.nextLine();

        Personajes personajeSeleccionado = personajesDAO.buscarPersonajesPorId(idPersonaje);
        if (personajeSeleccionado == null){
            System.out.println("Id del personaje no valido");
            return;
        }

        habilidadesDAO.cargarHabilidades();
        List<Habilidades> habilidades = habilidadesDAO.getLista_habilidades();
        System.out.println("Selecciona la ID de la habilidad que quieres equipar al personaje: ");
        for (Map.Entry <Habilidades, Boolean> entrada : personajeSeleccionado.getHabilidades_equipadas().entrySet()){
            System.out.println("-ID: " + entrada.getKey().getId() + " - Nombre: " + entrada.getKey().getNombre() + " - Daño: " + entrada.getKey().getDaño_base() + " - Numero de usos: " + entrada.getKey().getUsos_maximos() );
        }

        int idHabilidad = s.nextInt();
        s.nextLine();

        Habilidades habilidadSeleccionada = habilidadesDAO.buscarHabilidadesPorId(idHabilidad);
        if (habilidadSeleccionada == null){
            System.out.println("Id de la habilidad no valida");
            return;
        }

        if ()
    }

}
