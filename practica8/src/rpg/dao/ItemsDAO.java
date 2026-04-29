package rpg.dao;

import rpg.model.Items;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static rpg.dao.ConexionDB.getConnection;

public class ItemsDAO {
    private List<Items> lista_items;

    public ItemsDAO(){
        this.lista_items = new ArrayList<>();
        cargarItems();
    }

    public void cargarItems(){
        this.lista_items.clear();
        String sql = "SELECT * FROM Items";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()){
            while (rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                int precio_oro = rs.getInt("precio_oro");
                int bonificador_ataque = rs.getInt("bonificador_ataque");
                int bonificador_defensa = rs.getInt("bonificador_defensa");
                Items items = new Items(id, nombre, tipo, precio_oro, bonificador_ataque, bonificador_defensa);
                lista_items.add(items);
            }
            for (Items i : lista_items){
                System.out.println(i.getId() + " - " + i.getNombre());
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar los items: " +e.getMessage());
            e.printStackTrace();
        }
    }

    public HashMap<Items, Integer> getInventario(int idPersonaje){
        HashMap<Items, Integer> inventario = new HashMap<>();
        String sql = "SELECT i.id, inv.cantidad FROM Items i JOIN Inventarios inv ON i.id = inv.id_item WHERE inv.id_personaje = ?";

        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, idPersonaje);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                Items items = buscarItemsPorId(id);
                int cantidad = rs.getInt("cantidad");
                inventario.put(items, cantidad);
            }
        } catch (SQLException e){
            System.out.println("Error al cargar el inventario: " + e.getMessage());
            e.printStackTrace();
        }
        return inventario;
    }

    public Items buscarItemsPorId(int id){
        for (Items i : lista_items){
            if (i.getId() == id){
                return i;
            }
        }
        return null;
    }

    public List<Items> getLista_items() {
        return lista_items;
    }

    public void setLista_items(List<Items> lista_items) {
        this.lista_items = lista_items;
    }
}
