package rpg.dao;

import rpg.model.Ciudades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static rpg.dao.ConexionDB.getConnection;

public class CiudadesDAO {
    private List<Ciudades> lista_ciudades;

    public CiudadesDAO() {
        this.lista_ciudades = new ArrayList<>();
        ejemploConsulta();
    }

    public void ejemploConsulta() {
        this.lista_ciudades.clear();
        String sql = "SELECT * FROM Ciudades";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int nivel_minimo_acceso = rs.getInt("nivel_minimo_acceso");
                Ciudades ciudades = new Ciudades(id, nombre, nivel_minimo_acceso);
                lista_ciudades.add(ciudades);
            }
            for (Ciudades c : lista_ciudades){
                System.out.println(c.getId() + " - " + c.getNombre());
            }


        } catch (SQLException e) {
            System.out.println("Error al cargar las razas: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Ciudades> getLista_ciudades() {
        return lista_ciudades;
    }

    public void setLista_ciudades(List<Ciudades> lista_ciudades) {
        this.lista_ciudades = lista_ciudades;
    }
}
