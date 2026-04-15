package rpg.dao;

import rpg.model.Habilidades;
import java.sql.*;
import java.util.HashMap;


public class HabilidadesDAO {
    private Connection connection;
    public HabilidadesDAO(){
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/XRPG",
                    "xrpg_user",
                    "xrpg_password");

        } catch (SQLException e){
            System.out.println("Error en la conexión de la base de datos");
            e.printStackTrace();
        }


    }
    public HashMap<Habilidades, Boolean> obtenerHabilidadesPorPersonaje(int idPersonaje) {
        HashMap<Habilidades, Boolean> mapaHabilidades = new HashMap<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT h.*, ph.equipada_combate FROM Habilidades h JOIN Personajes_Habilidades ph ON  h.id = ph.id_habilidad WHERE ph.id_personaje  = " +idPersonaje);
            while (rs.next()){
                Habilidades habilidad = new Habilidades(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("dano_base"),
                        rs.getInt("usos_maximos"),
                        rs.getInt("id_clase")
                );
                boolean estaEquipada = rs.getBoolean("equipada_combate");
                mapaHabilidades.put(habilidad, estaEquipada);
            }
        } catch (SQLException e) {
            System.out.println("Error en la carga de la base de datos de habilidades");
            e.printStackTrace();
        }
        return mapaHabilidades;
    }
}


