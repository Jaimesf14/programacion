package rpg.dao;

import rpg.model.*;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

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
    public List<Personajes> cargarPersonajes(){
        List<Personajes> listaPersonajes = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            Statement stRaza = connection.createStatement();
            Statement stClase = connection.createStatement();
            Statement stCiudad = connection.createStatement();
            Statement stHabilidades = connection.createStatement();
            Statement stInventario = connection.createStatement();

            //CARGAR PERSONAJE
            ResultSet rsPersonaje = statement.executeQuery("SELECT * FROM Personajes");
            while (rsPersonaje.next()){
                int id = rsPersonaje.getInt("id");
                String nombre = rsPersonaje.getString("nombre");
                int nivel = rsPersonaje.getInt("nivel");
                int oro = rsPersonaje.getInt("oro");
                int vida_actual = rsPersonaje.getInt("vida_actual");

                //CARGA RAZAS
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

                //CARGA CLASES
                int id_clase = rsPersonaje.getInt("id_clase");
                ResultSet rsClase =stClase.executeQuery("SELECT * FROM Clases_rpg WHERE id ="+ id_clase);
                Clases_RPG clase = null;
                while (rsClase.next()){
                    int idClase = rsClase.getInt("id");
                    String nombreClase = rsClase.getString("nombre");
                    clase = new Clases_RPG(idClase, nombreClase);
                }

                //CARGA CIUDADES
                int id_ciudad_actual = rsPersonaje.getInt("id_ciudad_actual");
                ResultSet rsCiudad = stCiudad.executeQuery("SELECT * FROM Ciudades where id ="+ id_ciudad_actual);
                Ciudades ciudad  = null;
                while (rsCiudad.next()){
                    int idCiudad = rsCiudad.getInt("id");
                    String nombreCiudad = rsCiudad.getString("nombre");
                    int nivel_min = rsCiudad.getInt("nivel_minimo_acceso");
                    ciudad = new Ciudades(idCiudad, nombreCiudad, nivel_min);
                }

                Personajes personaje = new Personajes(id, nombre, nivel, oro, vida_actual, id_raza, id_clase, id_ciudad_actual);

                //CARGA HABILIDADES
                ResultSet rsHabilidades = stHabilidades.executeQuery("SELECT h.*, ph.equipada_combate FROM Habilidades h JOIN Personajes_Habilidades ph ON  h.id = ph.id_habilidad WHERE ph.id_personaje  = " +id);
                HashMap<Habilidades, Boolean> mapaHabilidades = new HashMap<>();
                while (rsHabilidades.next()){
                    int idHabilidades  = rsHabilidades.getInt("id");
                    String nombreHabilidades = rsHabilidades.getString("nombre");
                    int danio_base = rsHabilidades.getInt("dano_base");
                    int usos_maximos = rsHabilidades.getInt("usos_maximos");
                    int id_clase_habilidades = rsHabilidades.getInt("id_clase");

                    //para saber si esta equipada o no
                    boolean estaEquipada =  rsHabilidades.getBoolean("equipada_combate");

                    Habilidades habilidad = new Habilidades(idHabilidades, nombreHabilidades, danio_base, usos_maximos, id_clase_habilidades);

                    //metemos las cosas en el hashmap
                    mapaHabilidades.put(habilidad, estaEquipada);
                }
                personaje.setHabilidades(mapaHabilidades);

                //CARGA INVENTARIO
                ResultSet rsInventario = stInventario.executeQuery("SELECT i.*, inv.cantidad FROM Items i JOIN Inventarios inv ON i.id = inv.id_item WHERE inv.id_personaje = " + id);
                HashMap<Items, Integer> mapaInventario = new HashMap<>();
                while (rsInventario.next()){
                    int idItem = rsInventario.getInt("id");
                    String nombreItem = rsInventario.getString("nombre");
                    String tipoInventario = rsInventario.getString("tipo");
                    int precioItem = rsInventario.getInt("precio_oro");
                    int ataqueItem = rsInventario.getInt("bonificador_ataque");
                    int defensaItem = rsInventario.getInt("bonificador_defensa");
                    int cantidad = rsInventario.getInt("cantidad");

                    Items item = new Items(idItem, nombreItem, tipoInventario, precioItem, ataqueItem, defensaItem);

                    //metemos las cosas en el hashmap
                    mapaInventario.put(item, cantidad);
                }
                personaje.setInventario(mapaInventario);
                System.out.println("Cargado personaje: " + personaje);

            }
        } catch (SQLException e){
            System.out.println("Error en la carga de la base de datos de personajes");
            e.printStackTrace();
    }
        return listaPersonajes;
    }

}
