package rpg.ui;

import rpg.dao.CiudadesDAO;
import rpg.logic.EventosMundo;
import rpg.model.Ciudades;

import java.util.List;
import java.util.Scanner;

public class MenuEventos {
    private Scanner s = new Scanner(System.in);
    private CiudadesDAO ciudadesDAO = new CiudadesDAO();
    private EventosMundo eventosMundo = new EventosMundo();

    public void cobroImpuestos(){
        System.out.println("--- PAGAR IMPUESTOS ---");
        System.out.println("Selecciona la id de la ciudad a cobrar impuestos: ");
        List<String> ciudades = ciudadesDAO.listaCiudad();
        for (String c : ciudades){
            System.out.println(c);
        }
        int ciudadId = s.nextInt();
        eventosMundo.cobroImpuestos(ciudadId);
    }
}
