package rpg.dao;

import rpg.model.Clases_RPG;
import rpg.model.Razas;

import java.sql.*;

public class ClasesDAO {
    private Connection connection;
    public ClasesDAO(){
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/XRPG",
                    "xrpg_user",
                    "xrpg_password");

        } catch (SQLException e){
            System.out.println("Error en la conexión de la base de datos");
            e.printStackTrace();
        }


    }
    public Clases_RPG obtenerClasePorId(int idClase){
        Clases_RPG clase = null;
        try{
            Statement statement = connection.createStatement();
            ResultSet rs =statement.executeQuery("SELECT * FROM Clases_rpg WHERE id ="+ idClase);
            if (rs.next()) {
                clase = new Clases_RPG(
                        rs.getInt("id"),
                        rs.getString("nombre")
                );
            }
            System.out.println("Cargado clases: " + clase.getNombre());
        } catch (SQLException e) {
            System.out.println("Error en la carga de la base de datos de clases");
            e.printStackTrace();
        }
        return clase;
    }
}

