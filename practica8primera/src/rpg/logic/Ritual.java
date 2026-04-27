package rpg.logic;

import rpg.dao.PersonajeDAO;
import rpg.dao.RazasDAO;
import rpg.model.Items;
import rpg.model.Personajes;
import rpg.model.Razas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

public class Ritual {
    /*private PersonajeDAO personajeDAO = new PersonajeDAO();
    private RazasDAO razasDAO = new RazasDAO();
    public void procesarRitual(List<Personajes> expedicion, int idClaseEvolucionada){
        expedicion = personajeDAO.cargarPersonajes();
        Iterator<Personajes> iterator = expedicion.iterator();
        while(iterator.hasNext()){
            Personajes p = iterator.next();
            int itemsTotal = 0;

            for (Map.Entry<Items, Integer> inventario : p.getInventario().entrySet()){
                itemsTotal += inventario.getValue();
            }

            if (itemsTotal > 5){
                p.setId_clase(idClaseEvolucionada);
                p.setOro(p.getOro() - 50);
            }
            else if(p.getVida_actual() < p.getId_raza().getBonificador_vida() * 0.1){
                System.out.println(p.getNombre() + " ha sido desterrado.");
                iterator.remove();
                try {
                    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/XRPG", "xrpg_user", "xrpg_password");

                    PreparedStatement ps = conn.prepareStatement("UPDATE personajes SET id_ciudad_actual = NULL WHERE id = ?");

                    ps.setInt(1, p.getId());
                    ps.executeUpdate();

                    ps.close();
                    conn.close();

                } catch (Exception e){
                    e.printStackTrace();
                }

            }

        }
    }*/
}
