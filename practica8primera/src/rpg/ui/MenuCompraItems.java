package rpg.ui;

import rpg.dao.ItemsDAO;
import rpg.dao.PersonajeDAO;
import rpg.exception.FondosInsuficientesException;
import rpg.exception.NivelInsuficienteException;

import java.util.List;
import java.util.Scanner;

public class MenuCompraItems {
    private Scanner s = new Scanner(System.in);
    private PersonajeDAO personajeDAO = new PersonajeDAO();
    private ItemsDAO itemsDAO = new ItemsDAO();

    public void comprarItem(){
        System.out.println("--- TIENDA ---");
        System.out.println("Selecciona la id del personaje que quiere que realice la compra: ");
        List<String> personajes = personajeDAO.listaPersonajes();
        for (String p: personajes){
            System.out.println(p);
        }
        int personajeId = s.nextInt();

        System.out.println("Selecciona la id del item que quieres comprar: ");
        List<String> items = itemsDAO.listaItems();
        for (String i: items){
            System.out.println(i);
        }
        int itemsId = s.nextInt();
        try {
            personajeDAO.comprarItems(personajeId, itemsId);
            System.out.println("Se ha comprado con exito");

        }catch (FondosInsuficientesException e){
            System.out.println("NO puedes realizar la compra: " + e.getMessage());

        } catch (Exception e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
