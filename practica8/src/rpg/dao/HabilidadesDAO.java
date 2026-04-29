package rpg.dao;

import rpg.model.Habilidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static rpg.dao.ConexionDB.getConnection;

public class HabilidadesDAO {
    private List<Habilidades> lista_habilidades;

    public HabilidadesDAO() {
        this.lista_habilidades = new ArrayList<>();
        cargarHabilidades();
    }

    public void cargarHabilidades(){
        this.lista_habilidades.clear();
        String sql = "SELECT * FROM Habilidades";
        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()){
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int dano_base = rs.getInt("dano_base");
                int usos_maximos = rs.getInt("usos_maximos");
                int id_clase = rs.getInt("id_clase");
                Habilidades habilidades = new Habilidades(id, nombre, dano_base, usos_maximos, id_clase);
                lista_habilidades.add(habilidades);

            }
            for (Habilidades h : lista_habilidades){
                System.out.println(h.getId() + " - " + h.getNombre());
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar las habilidades: "  + e.getMessage());
            e.printStackTrace();
        }
    }

    public HashMap<Habilidades, Boolean> getHabilidadeEquipadas(int idPersonaje){
        HashMap<Habilidades, Boolean> habilidadesEquipadas = new HashMap<>();
        String sql = "SELECT h.id, ph.equipada_combate FROM Habilidades h JOIN Personajes_Habilidades ph ON  h.id = ph.id_habilidad WHERE ph.id_personaje  = ?";

        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, idPersonaje);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                Habilidades habilidades = buscarHabilidadesPorId(id);
                boolean equipada_combate = rs.getBoolean("equipada_combate");
                habilidadesEquipadas.put(habilidades, equipada_combate);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar las habilidades equipadas: " + e.getMessage());
            e.printStackTrace();
        }
        return habilidadesEquipadas;
    }

    public Habilidades buscarHabilidadesPorId(int  id){
        for (Habilidades h : lista_habilidades){
            if (h.getId() == id){
                return h;
            }
        }
        return null;
    }

    public List<Habilidades> getLista_habilidades() {
        return lista_habilidades;
    }

    public void setLista_habilidades(List<Habilidades> lista_habilidades) {
        this.lista_habilidades = lista_habilidades;
    }
}
