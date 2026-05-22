package rpg.logic;

import rpg.dao.*;
import rpg.model.Habilidades;
import rpg.model.Personajes;
import rpg.utils.LoggerCustom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static rpg.dao.ConexionDB.getConnection;

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

    public void combate(){
        System.out.println("===ELECCION DE LOS PERSONAJES===");

        int  cont = 1;
        int turno = 1;

        personajesDAO.cargarPersonajes();
        List<Personajes>personajes = personajesDAO.getLista_personajes();

        System.out.println("Selecciona la id del primer personaje que quieres que compita: ");
        for (Personajes p : personajes){
            System.out.println("-ID: " + p.getId() + " - Nombre: " + p.getNombre());
        }
        int id1 = s.nextInt();
        s.nextLine();

        Personajes personaje1 = personajesDAO.buscarPersonajesPorId(id1);
        if (personaje1 ==  null){
            System.out.println("Id del personaje no valido");
            return;
        }

        System.out.println("Selecciona la id del segundo personaje que quieres que compita: ");
        for (Personajes p : personajes){
            System.out.println("-ID: " + p.getId() + " - Nombre: " + p.getNombre());
        }
        int id2 = s.nextInt();
        s.nextLine();

        Personajes personaje2 = personajesDAO.buscarPersonajesPorId(id1);
        if (personaje2 ==  null){
            System.out.println("Id del personaje no valido");
            return;
        }

        System.out.println("===COMBATE===");
        while (personaje1.getVida_actual()>0 && personaje2.getVida_actual()>0){
            System.out.println("---------------------------------------------------------");
            System.out.println("| Ronda " + cont + " |");
            System.out.println("| Datos: |");
            System.out.println("| Personaje 1 | ID: " + personaje1.getId() + " - Nombre: " + personaje1.getNombre() +" - Vida: "+ personaje1.getVida_actual());
            System.out.println("| Personaje 2 | ID: " + personaje2.getId() + " - Nombre: " + personaje2.getNombre() +" - Vida: "+ personaje2.getVida_actual());

        }
    }

}
