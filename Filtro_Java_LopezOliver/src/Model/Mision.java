package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Mision {
    private int id;
    private String descripcion;
    private String rango;
    private int recompensa;

    public Mision(int id, String descripcion, String rango, int recompensa) {
        this.id = id;
        this.descripcion = descripcion;
        this.rango = rango;
        this.recompensa = recompensa;    
    }

    public void saveToDatabase(Connection connection) {
        String query = "INSERT INTO Mision (ID, Descripcion, Rango, Recompensa) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, this.id);
            stmt.setString(2, this.descripcion);
            stmt.setString(3, this.rango);
            stmt.setInt(4, this.recompensa);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}