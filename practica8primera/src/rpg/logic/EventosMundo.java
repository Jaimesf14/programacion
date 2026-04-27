package rpg.logic;

import rpg.dao.PersonajeDAO;
import rpg.model.Personajes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;

public class EventosMundo {
    private PersonajeDAO personajeDAO = new PersonajeDAO();

    public void cobroImpuestos(int idCiudad){
        List<Personajes> personajes = personajeDAO.cargarPersonajes();
        Iterator<Personajes> iterator = personajes.iterator();
        while(iterator.hasNext()){
            Personajes p = iterator.next();
            if (p.getId_ciudad_actual() != idCiudad){
                continue;
            }

            int oro = p.getOro() - 20;
            p.setOro(oro);
            try {
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/XRPG", "xrpg_user", "xrpg_password");

                PreparedStatement ps = conn.prepareStatement("UPDATE personajes SET oro = ? WHERE id = ?");

                ps.setInt(1, oro);
                ps.setInt(2, p.getId());
                ps.executeUpdate();

                ps.close();
                conn.close();

            } catch (Exception e){
                e.printStackTrace();
            }
            if (oro < 0){
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
            } else {
                System.out.println("El personaje " +p.getNombre() +" ha pagado 20 monedas de impuesto. Oro restante: " + p.getOro());
            }
        }
    }
}
