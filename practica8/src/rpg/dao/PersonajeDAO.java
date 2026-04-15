package rpg.dao;

import rpg.exception.FondosInsuficientesException;
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
            ResultSet rs = statement.executeQuery("SELECT * FROM personajes");
            while (rs.next()) {
                personajes.add(rs.getInt("id") + " - " + rs.getString("nombre") + " - Nivel: " + rs.getInt("nivel") + " - Oro disponible: " + rs.getInt("oro"));
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

    //COMPRAR ITEMS
    public void comprarItems(int personajeId, int itemID) throws FondosInsuficientesException {
        try{
            //Oro
            PreparedStatement ps1 = connection.prepareStatement("SELECT oro FROM personajes WHERE id=? ");
            ps1.setInt(1, personajeId);
            ResultSet rs1 = ps1.executeQuery();
            int oro = 0;
            if (rs1.next()){
                oro = rs1.getInt("oro");
            }

            //precio
            PreparedStatement ps2 = connection.prepareStatement("SELECT precio_oro FROM items WHERE id=? ");
            ps2.setInt(1, itemID);
            ResultSet rs2 = ps2.executeQuery();
            int precio = 0;
            if (rs2.next()){
                precio = rs2.getInt("precio_oro");
                if (precio>oro){
                    throw new FondosInsuficientesException("El personaje no dispone de suficiente oro");
                }
            }


            //restar el oro
            PreparedStatement ps3 = connection.prepareStatement("UPDATE personajes SET oro = oro - ? WHERE id=?");
            ps3.setInt(1, precio);
            ps3.setInt(2, personajeId);
            ps3.executeUpdate();

            //añadimos al inventario
            PreparedStatement ps4 = connection.prepareStatement("INSERT INTO inventarios (id_personaje, id_item) VALUES (?, ?)");
            ps4.setInt(1, personajeId);
            ps4.setInt(2, itemID);
            ps4.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al comprar el Item");
            e.printStackTrace();
        }
    }

}
