package rpg.dao;
import rpg.model.Items;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemsDAO {
    private Connection connection;
    public ItemsDAO(){
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/XRPG",
                    "xrpg_user",
                    "xrpg_password");

        } catch (SQLException e){
            System.out.println("Error en la conexión de la base de datos");
            e.printStackTrace();
        }
    }
    public HashMap<Items, Integer> obtenerInventarioPorPersonaje(int idPersonaje) {
        HashMap<Items, Integer> mapaInventario = new HashMap<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT i.*, inv.cantidad FROM Items i JOIN Inventarios inv ON i.id = inv.id_item WHERE inv.id_personaje = " + idPersonaje);
            while (rs.next()) {
                Items item = new Items(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("tipo"),
                        rs.getInt("precio_oro"),
                        rs.getInt("bonificador_ataque"),
                        rs.getInt("bonificador_defensa")
                );
                int cantidad = rs.getInt("cantidad");
                mapaInventario.put(item, cantidad);
            }

        } catch (SQLException e) {
            System.out.println("Error en la carga de la base de datos de items");
            e.printStackTrace();
        }
        return mapaInventario;
    }
    //LISTA ITEMS
    public List<String> listaItems(){
        List<String> items = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM items");
            while (rs.next()) {
                items.add(rs.getInt("id") + " - " + rs.getString("nombre") + " - Tipo: " + rs.getString("tipo") + " - Precio: " + rs.getInt("precio_oro"));
            }
        } catch (SQLException e) {
            System.out.println("Error en la carga de la base de datos de la lista de items");
            e.printStackTrace();
        }
        return items;
    }
}
