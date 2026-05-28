package rpg.logic;

import rpg.dao.*;
import rpg.model.Habilidades;
import rpg.model.Items;
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

        if (id1 == id2){
            System.out.println("No puedes elegir el mismo personaje");
            return;
        }

        Personajes personaje2 = personajesDAO.buscarPersonajesPorId(id2);
        if (personaje2 ==  null){
            System.out.println("Id del personaje no valido");
            return;
        }

        System.out.println("---ESTADISTICAS DEL JUGADOR 1---");
        double ataqueFisicoP1 = 0.00;
        for (Map.Entry<Items, Integer> i: personaje1.getInventario().entrySet()){
            ataqueFisicoP1 = ataqueFisicoP1 + (i.getKey().getBonificador_ataque() * i.getValue());
        }
        ataqueFisicoP1 = ataqueFisicoP1 + personaje1.getRazas().getBonificador_fuerza();
        System.out.println("-Ataque fisico total: " + ataqueFisicoP1);

        double defensaTotalP1 = 0.00;
        for (Map.Entry<Items, Integer> i: personaje1.getInventario().entrySet()){
            defensaTotalP1 = defensaTotalP1 + (i.getKey().getBonificador_defensa() * i.getValue());
        }
        System.out.println("-Defensa total: " + defensaTotalP1);

        System.out.println("---ESTADISTICAS DEL JUGADOR 2---");
        double ataqueFisicoP2 = 0.00;
        for (Map.Entry<Items, Integer> i: personaje2.getInventario().entrySet()){
            ataqueFisicoP2 = ataqueFisicoP2 + (i.getKey().getBonificador_ataque() * i.getValue());
        }
        ataqueFisicoP2 = ataqueFisicoP2 + personaje2.getRazas().getBonificador_fuerza();
        System.out.println("-Ataque fisico total: " + ataqueFisicoP2);

        double defensaTotalP2 = 0.00;
        for (Map.Entry<Items, Integer> i: personaje2.getInventario().entrySet()){
            defensaTotalP2 = defensaTotalP2 + (i.getKey().getBonificador_defensa() * i.getValue());
        }
        System.out.println("-Defensa total: " + defensaTotalP2);
        System.out.println(" ");

        HashMap<Habilidades, Integer> usosRestantes = new HashMap<>();

        personaje1.setHabilidades_equipadas(habilidadesDAO.getHabilidadeEquipadas(personaje1.getId()));
        personaje2.setHabilidades_equipadas(habilidadesDAO.getHabilidadeEquipadas(personaje2.getId()));

        for (Map.Entry<Habilidades, Boolean> h : personaje1.getHabilidades_equipadas().entrySet()){
            if (h.getValue()){
                usosRestantes.put(h.getKey(), h.getKey().getUsos_maximos());
            }
        }

        for (Map.Entry<Habilidades, Boolean> h : personaje2.getHabilidades_equipadas().entrySet()){
            if (h.getValue()){
                usosRestantes.put(h.getKey(), h.getKey().getUsos_maximos());
            }
        }

        int numHabilidades1 = 0;
        for (Boolean estaEquipada : personaje1.getHabilidades_equipadas().values()){
            if (estaEquipada == true){
                numHabilidades1 ++;
            }
        }
        if (numHabilidades1<3){
            System.out.println("El personaje " + personaje1.getNombre() +" no dispone de las suficientes habilidades para combatir");
            return;
        }

        int numHabilidades2 = 0;
        for (Boolean estaEquipada : personaje2.getHabilidades_equipadas().values()){
            if (estaEquipada == true){
                numHabilidades2 ++;
            }
        }
        if (numHabilidades2<3){
            System.out.println("El personaje " + personaje2.getNombre() +" no dispone de las suficientes habilidades para combatir");

            return;
        }

        System.out.println("===COMBATE===");
        while (personaje1.getVida_actual()>0 && personaje2.getVida_actual()>0){
            System.out.println("---------------------------------------------------------");
            System.out.println("| Ronda " + cont + " |");
            System.out.println("| Datos:  |");
            System.out.println("| Personaje 1 | ID: " + personaje1.getId() + " - Nombre: " + personaje1.getNombre() +" - Vida: "+ personaje1.getVida_actual());
            System.out.println("| Personaje 2 | ID: " + personaje2.getId() + " - Nombre: " + personaje2.getNombre() +" - Vida: "+ personaje2.getVida_actual());
            System.out.println("---------------------------------------------------------");


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
            System.out.println("| Elige el id de la habilidad que quieres que use: ");
            for (Map.Entry<Habilidades, Boolean> h : atacante.getHabilidades_equipadas().entrySet()){
                if (h.getValue() == true){
                    System.out.println("- ID: " + h.getKey().getId() + " - Nombre: " + h.getKey().getNombre() + " - Daño: " + h.getKey().getDaño_base() + " - Usos: " + usosRestantes.get(h.getKey()));
                }
            }
            int idHabilidad = s.nextInt();
            s.nextLine();

            Habilidades habilidadSeleccionada = habilidadesDAO.buscarHabilidadesPorId(idHabilidad);
            if (habilidadSeleccionada == null){
                System.out.println("Id de la habilidad elegida no valida.");
                return;
            }

            if (usosRestantes.get(habilidadSeleccionada)>0){
                double danioTotal;
                if (turno == 1){
                    danioTotal = habilidadSeleccionada.getDaño_base() - (defensaTotalP2/2);
                    defensor.setVida_actual(defensor.getVida_actual()-danioTotal);
                } else {
                    danioTotal = habilidadSeleccionada.getDaño_base() - (defensaTotalP1/2);
                    defensor.setVida_actual(defensor.getVida_actual()-danioTotal);
                }

                System.out.println("| El personaje " + atacante.getNombre() + " ha usado la habilidad " + habilidadSeleccionada.getNombre());

               int usos = usosRestantes.get(habilidadSeleccionada);
                usosRestantes.put(habilidadSeleccionada, usos-1);

            } else {
                double danioTotal;
                if (turno == 1){
                    danioTotal = ataqueFisicoP1 - (defensaTotalP2/2);
                    defensor.setVida_actual(defensor.getVida_actual()-danioTotal);

                }else{
                    danioTotal =ataqueFisicoP2 - (defensaTotalP1/2);
                    defensor.setVida_actual(defensor.getVida_actual()-danioTotal);

                }
                System.out.println("| El personaje " + atacante.getNombre() + " ha el ataque basico");
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
        Personajes ganador;
        Personajes perdedor;
        if (personaje1.getVida_actual()>0){
            ganador = personaje1;
            perdedor =personaje2;
        } else{
            ganador = personaje2;
            perdedor = personaje1;
        }

        double oroRobado = perdedor.getOro()*0.20;

        if (oroRobado>0){
            ganador.setOro(ganador.getOro() + oroRobado);
            perdedor.setOro(perdedor.getOro()-oroRobado);
            String sql = "UPDATE  PERSONAJES SET oro =? WHERE id = ?";
            try(Connection conn = getConnection()){
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setDouble(1, ganador.getOro());
                pstmt.setInt(2,ganador.getId());
                pstmt.executeUpdate();

                PreparedStatement pstmtPerdedor = conn.prepareStatement(sql);
                pstmtPerdedor.setDouble(1, perdedor.getOro());
                pstmtPerdedor.setInt(2, perdedor.getId());
                pstmtPerdedor.executeUpdate();

                LoggerCustom.info("[" + LocalDateTime.now() + "] INFO: El personaje " + ganador.getNombre() + " ha ganado el combate. Recibirá " + oroRobado + " por parte del personaje perdedor " + perdedor.getNombre());

                System.out.println("El personaje " + ganador.getNombre() + " ha ganado el combate. Recibirá " + oroRobado + " por parte del personaje perdedor " + perdedor.getNombre());


            } catch (SQLException e) {
                LoggerCustom.info("[" + LocalDateTime.now() + "] ERROR: Error al actualizar el oro del personaje ganador - " +e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("El personaje " + ganador.getNombre() + " ha ganado el combate. Recibirá " + oroRobado + " por parte del personaje perdedor " + perdedor.getNombre());
            System.out.println("El personaje " + ganador.getNombre() + "no recibirá direno puesto  que " + perdedor.getNombre() +);
        }


        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
    }

}
