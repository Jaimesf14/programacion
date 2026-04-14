package rpg.dao;

import rpg.model.Razas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RazasDAO {
    private Connection connection;
    public RazasDAO(){
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/XRPG",
                    "xrpg_user",
                    "xrpg_password");

        } catch (SQLException e){
            System.out.println("Error en la conexión de la base de datos");
            e.printStackTrace();
        }


    }
    public Razas obtenerRazaPorId(int idRaza){
        Razas raza = null;
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Razas WHERE id ="+ idRaza);
            if (rs.next()) {
                raza = new Razas(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("bonificador_vida"),
                        rs.getInt("bonificador_fuerza")
                );

            }
            System.out.println("Cargado raza: " + raza.getNombre());
        } catch (SQLException e) {
            System.out.println("Error en la carga de la base de datos de razas");
            e.printStackTrace();
        }
        return raza;
    }
    public List<String> listaRazas(){
        List<String> razas = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id, nombre FROM Razas");
            while (rs.next()) {
                razas.add(rs.getInt("id") + " - " + rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error en la carga de la base de datos de la lista de razas");
            e.printStackTrace();
        }
        return razas;
    }
}
