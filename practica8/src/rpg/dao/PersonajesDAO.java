package rpg.dao;

import rpg.model.Ciudades;
import rpg.model.ClasesRPG;
import rpg.model.Personajes;
import rpg.model.Razas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static rpg.dao.ConexionDB.getConnection;


public class PersonajesDAO {
    private List<Personajes> lista_personajes;
    private ItemsDAO itemsDAO;
    private HabilidadesDAO habilidadesDAO;
    private RazasDAO razasDAO;
    private ClasesRPGDAO clasesRPGDAO;
    private CiudadesDAO ciudadesDAO;

    public PersonajesDAO(ItemsDAO itemsDAO, HabilidadesDAO habilidadesDAO, RazasDAO razasDAO, ClasesRPGDAO clasesRPGDAO, CiudadesDAO ciudadesDAO) {
        this.lista_personajes = new ArrayList<>();
        this.itemsDAO = itemsDAO;
        this.habilidadesDAO = habilidadesDAO;
        this.razasDAO = razasDAO;
        this.clasesRPGDAO = clasesRPGDAO;
        this.ciudadesDAO = ciudadesDAO;
    }

    public void cargarPersonajes(){
        this.lista_personajes.clear();
        String sql = "SELECT * FROM Personajes";
        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs= pstmt.executeQuery()){
            while (rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int nivel = rs.getInt("nivel");
                int oro = rs.getInt("oro");
                int vida_actual = rs.getInt("vida_actual");
                int id_raza = rs.getInt("id_raza");
                Razas razas = razasDAO.buscarRazaPorId(id_raza);
                int id_clase = rs.getInt("id_clase");
                ClasesRPG clasesRPG  = clasesRPGDAO.buscarClasePorId(id_clase);
                int id_ciudad_actual =  rs.getInt("id_ciudad_actual");
                Ciudades ciudades = ciudadesDAO.buscarCiudadesPorId(id_ciudad_actual);

                Personajes personajes = new Personajes(id, nombre, nivel, oro, vida_actual, razas, clasesRPG, ciudades);

                personajes.setInventario(itemsDAO.getInventario(id));
                personajes.setHabilidades_equipadas(habilidadesDAO.getHabilidadeEquipadas(id));
                lista_personajes.add(personajes);
            }
            for (Personajes p: lista_personajes){
                System.out.println(p.getId() + " - " + p.getNombre());
            }
        } catch (SQLException e){
            System.out.println("Error al cargar los personajes: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Personajes buscarPersonajesPorId(int id){
        for (Personajes p : lista_personajes){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public List<Personajes> getLista_personajes() {
        return lista_personajes;
    }

    public void setLista_personajes(List<Personajes> lista_personajes) {
        this.lista_personajes = lista_personajes;
    }
}
