package rpg.dao;

import rpg.exception.NivelInsuficienteException;
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

    //LISTA PERSONAJES
    public List<String> listaPersonajes(){
        List<String> personajes = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id, nombre FROM personajes");
            while (rs.next()) {
                personajes.add(rs.getInt("id") + " - " + rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error en la carga de la base de datos de la lista de personajes");
            e.printStackTrace();
        }
        return personajes;
    }


    //CREAR PERSONAJE
    public void crearPersonaje(String nombre, int razaId, int claseId){
        try {
             PreparedStatement ps = connection.prepareStatement("INSERT INTO personajes (nombre, id_raza, id_clase, nivel, vida_actual, oro) VALUES (?, ?, ?, 1, 100, 100)");
             ps.setString(1, nombre);
             ps.setInt(2, razaId);
            ps.setInt(3, claseId);

            ps.executeUpdate();

            ps.close();

            System.out.println("Personaje creado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al crear personaje");
            e.printStackTrace();
        }

    }

    //VIAJAR CIUDAD
    public void viajar(int personajeId, int ciudadId) throws NivelInsuficienteException {
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT p.nivel, c.nivel_minimo_acceso FROM personajes p, ciudades c WHERE p.id=? AND c.id=?");
            ps.setInt(1, personajeId);
            ps.setInt(2, ciudadId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int nivel = rs.getInt("nivel");
                int nivelMin = rs.getInt("nivel_minimo_acceso");
                if (nivel < nivelMin) {
                    throw new NivelInsuficienteException("Nivel insuficiente");
                }
                PreparedStatement update = connection.prepareStatement("UPDATE personajes SET id_ciudad_actual=? WHERE id=?");
                update.setInt(1, ciudadId);
                update.setInt(2, personajeId);
                update.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error al viajar de ciudad");
            e.printStackTrace();
        }
    }

}
