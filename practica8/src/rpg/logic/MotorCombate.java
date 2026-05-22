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

    public void combate(){
        System.out.println("===ELECCION DE LOS PERSONAJES===");

        int  cont = 1;
        int turno = 1;

        personajesDAO.cargarPersonajes();
        List<Personajes>personajes = personajesDAO.getLista_personajes();

        System.out.println("Selecciona la id del primer personaje que quieres que compita: ");
        for (Personajes p : personajes){
            System.out.println("-ID: " + p.getId() + " - Nombre: " + p.getNombre());
        }
        int id1 = s.nextInt();
        s.nextLine();

        Personajes personaje1 = personajesDAO.buscarPersonajesPorId(id1);
        if (personaje1 ==  null){
            System.out.println("Id del personaje no valido");
            return;
        }

        System.out.println("Selecciona la id del segundo personaje que quieres que compita: ");
        for (Personajes p : personajes){
            System.out.println("- ID: " + p.getId() + " - Nombre: " + p.getNombre());
        }
        int id2 = s.nextInt();
        s.nextLine();

        Personajes personaje2 = personajesDAO.buscarPersonajesPorId(id2);
        if (personaje2 ==  null){
            System.out.println("Id del personaje no valido");
            return;
        }

        System.out.println("===COMBATE===");
        while (personaje1.getVida_actual()>0 && personaje2.getVida_actual()>0){
            System.out.println("---------------------------------------------------------");
            System.out.println("| Ronda " + cont + " |");
            System.out.println("| Datos: |");
            System.out.println("| Personaje 1 | ID: " + personaje1.getId() + " - Nombre: " + personaje1.getNombre() +" - Vida: "+ personaje1.getVida_actual());
            System.out.println("| Personaje 2 | ID: " + personaje2.getId() + " - Nombre: " + personaje2.getNombre() +" - Vida: "+ personaje2.getVida_actual());

            Personajes atacante;
            Personajes defensor;

            if (turno == 1){
                atacante = personaje1;
                defensor = personaje2;
            } else {
                atacante = personaje2;
                defensor = personaje1;
            }

            System.out.println("| Turno de " +atacante.getNombre()+ " de atacar.");
            System.out.println("| Elige el ide de la habilidad que quieres que use: ");
            for (Map.Entry<Habilidades, Boolean> h:atacante.getHabilidades_equipadas().entrySet()){
                System.out.println("- ID: " + h.getKey().getId() + " - Nombre: " + h.getKey().getNombre() + " - Daño: " + h.getKey().getDaño_base() + " - Usos: " + h.getKey().getUsos_maximos());
            }
            int idHabilidad = s.nextInt();
            s.nextLine();

            Habilidades habilidadSeleccionada = habilidadesDAO.buscarHabilidadesPorId(idHabilidad);
            if (habilidadSeleccionada == null){
                System.out.println("Id de la habilidad elegida no valida.");
                return;
            }

            if (habilidadSeleccionada.getUsos_maximos()>0){
                int danioTotal = habilidadSeleccionada.getDaño_base();
                defensor.setVida_actual(defensor.getVida_actual()-danioTotal);
                habilidadSeleccionada.setUsos_maximos(habilidadSeleccionada.getUsos_maximos()-1);
                System.out.println("| El personaje " + atacante.getNombre() + " ha usado la habilidad " + habilidadSeleccionada.getNombre());


                String sql = "UPDATE personajes SET vida_actual = ? WHERE id = ?";
                try(Connection conn = getConnection();
                    PreparedStatement pstmt = conn.prepareStatement(sql)){
                    pstmt.setInt(1, defensor.getVida_actual());
                    pstmt.setInt(2, defensor.getId());
                    pstmt.executeUpdate();

                } catch (SQLException e) {
                    LoggerCustom.info("[" + LocalDateTime.now() + "] ERROR: Error al  restarle vida al personaje " + defensor.getNombre() + " - " +e.getMessage());
                    e.printStackTrace();
                }

                String sql2 = "UPDATE habilidades SET usos_maximos = ? WHERE id = ?";
                try(Connection conn = getConnection();
                    PreparedStatement pstmt = conn.prepareStatement(sql2)){
                    pstmt.setInt(1, habilidadSeleccionada.getUsos_maximos());
                    pstmt.setInt(2, habilidadSeleccionada.getId());
                    pstmt.executeUpdate();

                } catch (SQLException e) {
                    LoggerCustom.info("[" + LocalDateTime.now() + "] ERROR: Error al restarle un uso a la habilidad " + habilidadSeleccionada.getNombre() + " - " +e.getMessage());
                    e.printStackTrace();
                }

            } else {
                System.out.println("Pierde turno");
            }

            //Cambiar turno
            if (turno == 1) {
                turno = 2;
            }
            else{
                turno = 1;
            }
            cont++;
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        if (personaje1.getVida_actual()>0){
            System.out.println("| El ganador es: " + personaje1.getNombre());
        } else{
            System.out.println("| El ganador es: " + personaje2.getNombre());
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
    }

}
