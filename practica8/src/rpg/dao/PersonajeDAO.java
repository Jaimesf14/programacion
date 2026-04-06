package rpg.dao;

import rpg.model.Ciudades;
import rpg.model.Clases_RPG;
import rpg.model.Razas;

import java.sql.*;

public class PersonajeDAO {
    private Connection connection;
    public PersonajeDAO(){
    try {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/XRPG",
                                                            "xrpg_user",
                                                            "xrpg_password");

        } catch (SQLException e){
            System.out.println("Error en la conexión de la base de datos");
            e.printStackTrace();
        }
    }
    public void cargarPersonajes(){
        try {
            Statement statement = connection.createStatement();
            Statement stRaza = connection.createStatement();
            Statement stClase = connection.createStatement();
            Statement stCiudad = connection.createStatement();

            ResultSet rsPersonaje = statement.executeQuery("SELECT * FROM Personajes");
            while (rsPersonaje.next()){
                int id = rsPersonaje.getInt("id");
                String nombre = rsPersonaje.getString("nombre");
                int nivel = rsPersonaje.getInt("nivel");
                int vida_actual = rsPersonaje.getInt("vida_actual");
                int id_raza = rsPersonaje.getInt("id_raza");

                ResultSet rsRaza = stRaza.executeQuery("SELECT * FROM Razas WHERE id ="+ id_raza);
                Razas raza = null;
                while (rsRaza.next()){
                    int idRaza = rsRaza.getInt("id");
                    String nombreRaza = rsRaza.getString("nombre");
                    int bonificador_vida = rsRaza.getInt("bonificador_vida");
                    int bonificador_fuerza = rsRaza.getInt("bonificador_fuerza");
                    raza = new Razas(idRaza, nombreRaza,bonificador_vida, bonificador_fuerza);
                }

                int id_clase = rsPersonaje.getInt("id_clase");
                ResultSet rsClase =stClase.executeQuery("SELECT * FROM Clases_rpg WHERE id ="+ id_clase);
                Clases_RPG clase = null;
                while (rsClase.next()){
                    int idClase = rsClase.getInt("id");
                    String nombreClase = rsClase.getString("nombre");
                    clase = new Clases_RPG(idClase, nombreClase);
                }

                int id_ciudad_actual = rsPersonaje.getInt("id_ciudad_actual");
                ResultSet rsCiudad = stCiudad.executeQuery("SELECT * FROM Ciudades where id ="+ id_ciudad_actual);
                Ciudades ciudad  = null;
                while (rsCiudad.next()){
                    int idCiudad = rsCiudad.getInt("id");
                    String nombreCiudad = rsCiudad.getString("nombre");
                    int nivel_min = rsCiudad.getInt("nivel_min");
                    ciudad = new Ciudades(idCiudad, nombreCiudad, nivel_min);
                }

            }
        } catch (SQLException e){
            System.out.println("Error en la carga de la base de datos de personajes");
            e.printStackTrace();
    }


    }
}
