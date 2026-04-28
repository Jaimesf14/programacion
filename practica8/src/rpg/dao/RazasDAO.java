package rpg.dao;

import rpg.model.Razas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static rpg.dao.ConexionDB.getConnection;

public class RazasDAO {
    private List<Razas>lista_razas;

    public RazasDAO() {
        this.lista_razas = new ArrayList<>();
        cargarRazas();
    }

    public void cargarRazas() {
        this.lista_razas.clear();
        String sql = "SELECT * FROM Razas";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int bonificador_vida = rs.getInt("bonificador_vida");
                int bonificador_fuerza = rs.getInt("bonificador_fuerza");
                Razas raza = new Razas(id, nombre, bonificador_vida, bonificador_fuerza);
                lista_razas.add(raza);
            }
            for (Razas r : lista_razas){
                System.out.println(r.getId() + " - " + r.getNombre());
            }


        } catch (SQLException e) {
            System.out.println("Error al cargar las razas: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Razas buscarRazaPorId(int id){
        for (Razas r : lista_razas){
            if (r.getId() == id){
                return r;
            }
        }
        return null;
    }

    public List<Razas> getLista_razas() {
        return lista_razas;
    }

    public void setLista_razas(List<Razas> lista_razas) {
        this.lista_razas = lista_razas;
    }
}
