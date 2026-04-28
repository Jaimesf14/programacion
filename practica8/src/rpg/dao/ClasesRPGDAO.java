package rpg.dao;

import rpg.model.ClasesRPG;
import rpg.model.Razas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static rpg.dao.ConexionDB.getConnection;

public class ClasesRPGDAO {
    private List<ClasesRPG> lista_clases;

    public ClasesRPGDAO() {
        this.lista_clases = new ArrayList<>();
        cargarClases();
    }

    public void cargarClases() {
        this.lista_clases.clear();
        String sql = "SELECT * FROM Clases_rpg";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                ClasesRPG clasesRPG = new ClasesRPG(id, nombre);
                lista_clases.add(clasesRPG);
            }
            for (ClasesRPG c : lista_clases){
                System.out.println(c.getId() + " - " + c.getNombre());
            }


        } catch (SQLException e) {
            System.out.println("Error al cargar las razas: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public ClasesRPG buscarClasePorId(int id){
        for (ClasesRPG c : lista_clases){
            if (c.getId() == id){
                return c;
            }
        }
        return null;
    }

    public List<ClasesRPG> getLista_clases() {
        return lista_clases;
    }

    public void setLista_clases(List<ClasesRPG> lista_clases) {
        this.lista_clases = lista_clases;
    }
}
