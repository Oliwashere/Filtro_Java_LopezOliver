package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ninja {
    private int id;
    private String nombre;
    private String rango;
    private String aldea;

    public Ninja(int id, String nombre, String rango, String aldea) {
        this.id = id;
        this.nombre = nombre;
        this.rango = rango;
        this.aldea = aldea;    
    }

    public void saveToDatabase(Connection connection) {
        String query = "INSERT INTO Ninja (ID, Nombre, Rango, Aldea) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, this.id);
            stmt.setString(2, this.nombre);
            stmt.setString(3, this.rango);
            stmt.setString(4, this.aldea);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}