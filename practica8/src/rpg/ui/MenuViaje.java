package rpg.ui;

import rpg.dao.CiudadesDAO;
import rpg.dao.PersonajeDAO;
import rpg.exception.NivelInsuficienteException;

import java.util.List;
import java.util.Scanner;

public class MenuViaje {
    private Scanner s = new Scanner(System.in);
    private PersonajeDAO personajeDAO = new PersonajeDAO();
    private CiudadesDAO ciudadesDAO = new CiudadesDAO();

    public void viajarCiudad() throws NivelInsuficienteException {
        System.out.println("--- VIAJAR DE CIUDAD ---");
        List<String> personajes = personajeDAO.listaPersonajes();
        System.out.println("Selecciona la id de un personaje: ");
        for (String p: personajes){
            System.out.println(p);
        }
        int personajeId = s.nextInt();

        System.out.println("Selecciona el ID de la ciudad de destino: ");
        List<String> ciudades = ciudadesDAO.listaCiudad();
        for (String c: ciudades){
            System.out.println(c);
        }
        int ciudadeId = s.nextInt();
        personajeDAO.viajar(personajeId, ciudadeId);
        System.out.println("Se ha viajado con exito");
    }
}
