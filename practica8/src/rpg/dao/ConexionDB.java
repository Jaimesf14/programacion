package rpg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:postgresql://localhost:5432/XRPG";
    private static final String USER = "xrpg_user";
    private static final String PASSWORD = "xrpg_password";
    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Error conectando a la BD", e);
        }
    }

}
