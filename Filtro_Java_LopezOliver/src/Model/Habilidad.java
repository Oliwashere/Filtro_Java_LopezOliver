package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Habilidad {
    private int idNinja;
    private String nombre;
    private String descripcion;

    public Habilidad(int idNinja, String nombre, String descripcion) {
        this.idNinja = idNinja;
        this.nombre = nombre;
        this.descripcion = descripcion;    
    }

    public void saveToDatabase(Connection connection) {
        String query = "INSERT INTO Habilidad (ID_Ninja, Nombre, Descripcion) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, this.idNinja);
            stmt.setString(2, this.nombre);
            stmt.setString(3, this.descripcion);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}