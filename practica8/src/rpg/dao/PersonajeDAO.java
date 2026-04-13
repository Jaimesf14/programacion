package rpg.dao;

import rpg.model.*;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonajeDAO {
    private Connection connection;
    private HabilidadesDAO habilidadesDAO;
    private ItemsDAO itemsDAO;

    public PersonajeDAO(){
    try {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/XRPG",
                                                            "xrpg_user",
                                                            "xrpg_password");
        habilidadesDAO = new HabilidadesDAO();
        itemsDAO = new ItemsDAO();

        } catch (SQLException e){
            System.out.println("Error en la conexión de la base de datos");
            e.printStackTrace();
        }


    }
    public List<Personajes> cargarPersonajes(){
        List<Personajes> listaPersonajes = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rsPersonaje = statement.executeQuery("SELECT * FROM Personajes");
            while (rsPersonaje.next()){
                int id = rsPersonaje.getInt("id");
                String nombre = rsPersonaje.getString("nombre");
                int nivel = rsPersonaje.getInt("nivel");
                int oro = rsPersonaje.getInt("oro");
                int vida_actual = rsPersonaje.getInt("vida_actual");
                int id_raza = rsPersonaje.getInt("id_raza");
                int id_clase = rsPersonaje.getInt("id_clase");
                int id_ciudad_actual = rsPersonaje.getInt("id_ciudad_actual");

                Personajes personaje = new Personajes(id, nombre, nivel, oro, vida_actual, id_raza, id_clase, id_ciudad_actual);

                //CARGA HABILIDADES E INVENTARIO
                personaje.setHabilidades(habilidadesDAO.obtenerHabilidadesPorPersonaje(id));
                personaje.setInventario(itemsDAO.obtenerInventarioPorPersonaje(id));
                System.out.println("Cargado personaje: " + personaje.getNombre());
                listaPersonajes.add(personaje);

            }
        } catch (SQLException e){
            System.out.println("Error en la carga de la base de datos de personajes");
            e.printStackTrace();
    }
        return listaPersonajes;
    }



}
