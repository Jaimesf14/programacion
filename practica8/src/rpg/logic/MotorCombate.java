package rpg.logic;

import rpg.dao.*;
import rpg.model.Habilidades;
import rpg.model.Personajes;
import rpg.utils.LoggerCustom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static rpg.dao.ConexionDB.getConnection;

public class MotorCombate {
    private Scanner s = new Scanner(System.in);
    private ItemsDAO itemsDAO;
    private HabilidadesDAO habilidadesDAO;
    private RazasDAO razasDAO;
    private ClasesRPGDAO clasesRPGDAO;
    private CiudadesDAO ciudadesDAO;
    private PersonajesDAO personajesDAO;

    public MotorCombate(ItemsDAO itemsDAO, HabilidadesDAO habilidadesDAO, RazasDAO razasDAO, ClasesRPGDAO clasesRPGDAO, CiudadesDAO ciudadesDAO) {
        this.itemsDAO = itemsDAO;
        this.habilidadesDAO = habilidadesDAO;
        this.razasDAO = razasDAO;
        this.clasesRPGDAO = clasesRPGDAO;
        this.ciudadesDAO = ciudadesDAO;
        this.personajesDAO = new PersonajesDAO(itemsDAO, habilidadesDAO, razasDAO, clasesRPGDAO, ciudadesDAO);
    }

    //------------------------------------------------------------------------------------------------------------------

    public void eleccionHabilidades(){
        System.out.println("===ELECCION DE HABILIDADES===");
        personajesDAO.cargarPersonajes();
        List<Personajes>personajes = personajesDAO.getLista_personajes();
        System.out.println("Selecciona la id del personaje el cual quieres que elija habilidades: ");
        for (Personajes p : personajes){
            System.out.println("- ID: " + p.getId() + " - Nombre: " + p.getNombre());
        }

        int idPersonaje = s.nextInt();
        s.nextLine();

        Personajes personajeSeleccionado = personajesDAO.buscarPersonajesPorId(idPersonaje);
        if (personajeSeleccionado == null){
            System.out.println("Id del personaje no valido");
            return;
        }
        habilidadesDAO.cargarHabilidades();

        List<Habilidades> habilidadesClase = habilidadesDAO.getHabilidadesClase(personajeSeleccionado.getClasesRPG().getId());

        HashMap<Habilidades, Boolean> estaEquipada = habilidadesDAO.getHabilidadeEquipadas(personajeSeleccionado.getId());
        personajeSeleccionado.setHabilidades_equipadas(estaEquipada);

        System.out.println("Selecciona la ID de la habilidad que quieres equipar al personaje: ");

        for (Habilidades h : habilidadesClase){

            System.out.println("-ID: " + h.getId() + " - Nombre: " + h.getNombre() + " - Daño: " + h.getDaño_base() + " - Numero de usos: " + h.getUsos_maximos());
        }
        int idHabilidad = s.nextInt();
        s.nextLine();

        Habilidades habilidadSeleccionada = habilidadesDAO.buscarHabilidadesPorId(idHabilidad);
        if (habilidadSeleccionada == null){
            System.out.println("Id de la habilidad no valida");
            return;
        }

        Boolean equipada =
                personajeSeleccionado
                        .getHabilidades_equipadas()
                        .get(habilidadSeleccionada);

        if (equipada != null && equipada) {

            System.out.println(
                    "Esta habilidad ya esta seleccionada."
            );

            return;
        }

        if (estaEquipada.containsKey(habilidadSeleccionada)) {

            String sql =
                    "UPDATE personajes_habilidades " +
                            "SET equipada_combate = true " +
                            "WHERE id_personaje = ? " +
                            "AND id_habilidad = ?";
        //if (personajeSeleccionado.getHabilidades_equipadas().get(habilidadSeleccionada)) {
        //    System.out.println("Esta habilidad ya esta seleccionada.");
        } else {
            String sql = "UPDATE personajes_habilidades SET equipada_combate = ? WHERE id_personaje = ? AND id_habilidad = ?";
            try(Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setBoolean(1, true);
                pstmt.setInt(2, personajeSeleccionado.getId());
                pstmt.setInt(3, habilidadSeleccionada.getId());
                personajeSeleccionado.getHabilidades_equipadas().put(habilidadSeleccionada, true);
                pstmt.executeUpdate();
                System.out.println("Habilidad equipada con exito");
                LoggerCustom.info("[" + LocalDateTime.now() + "] INFO: Al personaje " + personajeSeleccionado.getNombre() + " se le ha añadido la habilidad " + habilidadSeleccionada.getNombre());
            } catch (SQLException e) {
                LoggerCustom.info("[" + LocalDateTime.now() + "] ERROR: Error al añadir la habilidad - " +e.getMessage());
                e.printStackTrace();
            }
        }
    }

}
