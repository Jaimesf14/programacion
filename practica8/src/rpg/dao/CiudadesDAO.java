package rpg.dao;

import rpg.model.Ciudades;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CiudadesDAO {
    private Connection connection;
    public CiudadesDAO(){
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/XRPG",
                    "xrpg_user",
                    "xrpg_password");

        } catch (SQLException e){
            System.out.println("Error en la conexión de la base de datos");
            e.printStackTrace();
        }


    }
    public Ciudades obtenerCiudadPorId(int idCiudad) {
        Ciudades ciudad = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Ciudades WHERE id = " + idCiudad);
            if (rs.next()) {
                ciudad = new Ciudades(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("nivel_minimo_acceso")
                );
            }
            System.out.println("Cargado CIUDADES: " + ciudad.getNombre());
        } catch (SQLException e) {
            System.out.println("Error en la carga de la base de datos de ciudades");
            e.printStackTrace();
        }
        return ciudad;
    }

    //LISTA CIUDADES
    public List<String> listaCiudad(){
        List<String> ciudades = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ciudades");
            while (rs.next()) {
                ciudades.add(rs.getInt("id") + " - " + rs.getString("nombre") + " - Nivel minimo de acceso: " + rs.getInt("nivel_minimo_acceso"));
            }
        } catch (SQLException e) {
            System.out.println("Error en la carga de la base de datos de la lista de ciudades");
            e.printStackTrace();
        }
        return ciudades;

    }
}
