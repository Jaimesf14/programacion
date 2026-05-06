package rpg.logic;

import rpg.dao.*;
import rpg.exception.FondosInsuficientesException;
import rpg.exception.NivelInsuficienteException;
import rpg.model.*;
import rpg.utils.LoggerCustom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static rpg.dao.ConexionDB.getConnection;

public class GestionMundo {
    private Scanner s = new Scanner(System.in);
    private ItemsDAO itemsDAO;
    private HabilidadesDAO habilidadesDAO;
    private RazasDAO razasDAO;
    private ClasesRPGDAO clasesRPGDAO;
    private CiudadesDAO ciudadesDAO;
    private PersonajesDAO personajesDAO;


    public GestionMundo(ItemsDAO itemsDAO, HabilidadesDAO habilidadesDAO, RazasDAO razasDAO, ClasesRPGDAO clasesRPGDAO, CiudadesDAO ciudadesDAO) {
        this.itemsDAO = itemsDAO;
        this.habilidadesDAO = habilidadesDAO;
        this.razasDAO = razasDAO;
        this.clasesRPGDAO = clasesRPGDAO;
        this.ciudadesDAO = ciudadesDAO;
        this.personajesDAO = new PersonajesDAO(itemsDAO, habilidadesDAO, razasDAO, clasesRPGDAO, ciudadesDAO
        );
    }

    public void crearPersonaje(){
        try{
            System.out.println("===CREAR PERSONAJE===");

            //Nombre
            System.out.println("Nombre: ");
            String nombre = s.nextLine();

            //Raza
            razasDAO.cargarRazas();
            List<Razas> razas = razasDAO.getLista_razas();
            System.out.println("Selecciona el ID de la raza que desea: ");
            for (Razas r : razas){
                System.out.println("- ID: " + r.getId() + " - " + r.getNombre() + " - Bonificador fuerza: " + r.getBonificador_fuerza() + " - Bonificador vida: " + r.getBonificador_vida());
            }
            int idRaza = s.nextInt();
            s.nextLine();

            Razas razaSeleccionada = razasDAO.buscarRazaPorId(idRaza);
            if (razaSeleccionada == null){
                System.out.println("Id de la raza no valido");
                return;
                //Pongo el return, para cortar el metodo ya que no existe el id, y asi no meta datos erroneos a la base de datos.
            }

            //Clase
            clasesRPGDAO.cargarClases();
            List<ClasesRPG> clases = clasesRPGDAO.getLista_clases();
            System.out.println("Selecciona el ID de la clase que desea: ");
            for (ClasesRPG  c : clases){
                System.out.println("- ID: " + c.getId() + " - " + c.getNombre());
            }
            int idClase = s.nextInt();
            s.nextLine();

            ClasesRPG claseSeleccionada = clasesRPGDAO.buscarClasePorId(idClase);
            if (claseSeleccionada == null){
                System.out.println("Id de la clase no valido");
                return;
            }

            //Ciudad
            ciudadesDAO.cargarCiudades();
            List<Ciudades> ciudades = ciudadesDAO.getLista_ciudades();
            System.out.println("Selecciona el ID de la ciudad que desea: ");
            for (Ciudades c : ciudades){
                System.out.println("- ID: " + c.getId() + " - " + c.getNombre() + " - " + c.getNivel_minimo_acceso());
            }
            int idCiudad = s.nextInt();
            s.nextLine();

            Ciudades ciudadSeleccionada = ciudadesDAO.buscarCiudadesPorId(idCiudad);
            if (ciudadSeleccionada == null){
                System.out.println("Id de la ciudad no valido");
                return;
            }

            Personajes personaje = new Personajes(0,nombre,1,100,100,razaSeleccionada,claseSeleccionada,ciudadSeleccionada);
            personajesDAO.crearPersonajes(personaje);
            System.out.println("Personaje creado correctamente");
            LoggerCustom.info("[" + LocalDateTime.now() + "] INFO: Personaje creado correctamente");


        } catch (Exception e) {
            LoggerCustom.info("[" + LocalDateTime.now() + "] ERROR: Error al crear el personaje - " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void viajarCiudad() throws NivelInsuficienteException {
        System.out.println("===VIAJAR===");

        personajesDAO.cargarPersonajes();
        List<Personajes> personajes = personajesDAO.getLista_personajes();

        System.out.println("Selecciona la id del personaje que quieres que cambie de ciudad: ");
        for (Personajes p : personajes){
            System.out.println("- ID: " + p.getId() + " - Nombre: " + p.getNombre() + " - Nivel: " + p.getNivel() +  " - Ciudad actual: " + p.getCiudades().getNombre());
        }
        int idPersonaje = s.nextInt();
        s.nextLine();

        Personajes personajeSeleccionado = personajesDAO.buscarPersonajesPorId(idPersonaje);
        if (personajeSeleccionado == null){
            System.out.println("Id del personaje no valido");
            return;
        }

        ciudadesDAO.cargarCiudades();
        List<Ciudades> ciudades = ciudadesDAO.getLista_ciudades();
        System.out.println("Selecciona la id de la ciudad donde quieres que viaje el personaje: ");
        for (Ciudades c : ciudades){
            System.out.println("- ID: " + c.getId() + " - Nombre: " + c.getNombre() + " - Nivel Minimo de Acceso: " +c.getNivel_minimo_acceso());
        }
        int idCiudad = s.nextInt();
        s.nextLine();

        Ciudades ciudadSeleccionado  = ciudadesDAO.buscarCiudadesPorId(idCiudad);
        if (ciudadSeleccionado == null){
            System.out.println("Id de la ciudad no valida");
            return;
        }

        String sql = "UPDATE personajes SET id_ciudad_actual = ? WHERE id = ? ";

        if (personajeSeleccionado.getNivel() < ciudadSeleccionado.getNivel_minimo_acceso()){
            LoggerCustom.info("[" + LocalDateTime.now() + "] ERROR: Nivel insuficiente del personaje " + personajeSeleccionado.getNombre() + " para cambiar a la ciudad " + ciudadSeleccionado.getNombre());
            throw new NivelInsuficienteException("Nivel de personaje insuficiente");

        }
        try(Connection conn = getConnection();
            PreparedStatement update = conn.prepareStatement(sql)){
            update.setInt(1,  idCiudad);
            update.setInt(2, idPersonaje);
            update.executeUpdate();
            System.out.println("Viaje realizado con exito");
            LoggerCustom.info("[" + LocalDateTime.now() + "] INFO: El personaje " + idPersonaje + " ha cambiado de ciudad");

        }catch (SQLException e) {
            LoggerCustom.info("[" + LocalDateTime.now() + "] ERROR: Error al cambiar de ciudad - " +e.getMessage());
            e.printStackTrace();
        }

    }

    public void tienda() throws FondosInsuficientesException {
        System.out.println("===TIENDA===");

        //Mostrar personajes
        personajesDAO.cargarPersonajes();
        List<Personajes> personajes = personajesDAO.getLista_personajes();

        System.out.println("Selecciona la id del personaje que quieres que cambie de ciudad: ");
        for (Personajes p : personajes){
            System.out.println("- ID: " + p.getId() + " - Nombre: " + p.getNombre() + " - Nivel: " + p.getNivel() +  " - Oro: " + p.getOro());
        }
        int idPersonaje = s.nextInt();
        s.nextLine();

        Personajes personajeSeleccionado = personajesDAO.buscarPersonajesPorId(idPersonaje);
        if (personajeSeleccionado == null){
            System.out.println("Id del personaje no valido");
            return;
        }

        //Mostrar todos los items
        itemsDAO.cargarItems();
        List<Items> items = itemsDAO.getLista_items();
        for (Items i : items){
            System.out.println("- ID: " + i.getId() + " - Nombre: " + i.getNombre() + " - Tipo: " + i.getTipo() + " - Precio: " + i.getPrecio_oro() + " - Bonificador ataque: " +  i.getBonificador_ataque() + " - Bonificador defensa: " + i.getBonificador_defensa());
        }
        int idItem  = s.nextInt();
        s.nextLine();

        Items itemSeleccionado = itemsDAO.buscarItemsPorId(idItem);
        if (itemSeleccionado == null){
            System.out.println("Id del item no valido");
            return;
        }

        if (itemSeleccionado.getPrecio_oro() > personajeSeleccionado.getOro()){
            LoggerCustom.info("[" + LocalDateTime.now() + "] ERROR: El personaje " + personajeSeleccionado.getNombre() + " no dispone de oro suficiente para compra el item " +itemSeleccionado.getNombre());
            throw new FondosInsuficientesException("Cantidad de oro insuficiente para comprar el item");
        }
        String sqlUpdate = "UPDATE personajes SET oro = oro - ? WHERE id=?";
        String sqlInsert = "INSERT INTO inventarios (id_personaje, id_item) VALUES (?, ?)";
        String sqlUpdateCant = "UPDATE inventarios SET cantidad = cantidad + 1 WHERE id_personaje = ? AND id_item = ?";
        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)){
            pstmt.setInt(1, itemSeleccionado.getPrecio_oro());
            pstmt.setInt(2, personajeSeleccionado.getId());
            pstmt.executeUpdate();

            if (personajeSeleccionado.getInventario().containsKey(itemSeleccionado)){
                PreparedStatement update = conn.prepareStatement(sqlUpdateCant);
                update.setInt(1, personajeSeleccionado.getId());
                update.setInt(2, itemSeleccionado.getId());
                update.executeUpdate();

            }else {
                PreparedStatement insert = conn.prepareStatement(sqlInsert);
                insert.setInt(1, personajeSeleccionado.getId());
                insert.setInt(2, itemSeleccionado.getId());
                insert.executeUpdate();
            }

            LoggerCustom.info("[" + LocalDateTime.now() + "] INFO: El personaje - " + personajeSeleccionado.getNombre() + " ha comprado el item " + itemSeleccionado.getNombre());


        } catch (SQLException e) {
            LoggerCustom.info("[" + LocalDateTime.now() + "] ERROR: Error al comprar el item - " +e.getMessage());
            e.printStackTrace();
        }
    }

}
