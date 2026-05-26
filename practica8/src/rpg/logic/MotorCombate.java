package rpg.logic;

import rpg.dao.*;
import rpg.model.Habilidades;
import rpg.model.Personajes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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

        HashMap<Habilidades, Integer> usosRestantes = new HashMap<>();

        personaje1.setHabilidades_equipadas(habilidadesDAO.getHabilidadeEquipadas(personaje1.getId()));
        personaje2.setHabilidades_equipadas(habilidadesDAO.getHabilidadeEquipadas(personaje2.getId()));

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
                int danioTotal = habilidadSeleccionada.getDaño_base();
                defensor.setVida_actual(defensor.getVida_actual()-danioTotal);

                System.out.println("| El personaje " + atacante.getNombre() + " ha usado la habilidad " + habilidadSeleccionada.getNombre());

               int usos = usosRestantes.get(habilidadSeleccionada);
                usosRestantes.put(habilidadSeleccionada, usos-1);

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
