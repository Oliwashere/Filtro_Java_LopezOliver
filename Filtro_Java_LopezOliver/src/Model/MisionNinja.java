package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MisionNinja {
    private int idNinja;
    private int idMision;
    private String fechaInicio;
    private String fechaFin;

    public MisionNinja(int idNinja, int idMision, String fechaInicio, String fechaFin) {
        this.idNinja = idNinja;
        this.idMision = idMision;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;    
    }

    public void saveToDatabase(Connection connection) {
        String query = "INSERT INTO MisionNinja (ID_Ninja, ID,Mision, FechaInicio, FechaFin) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, this.idNinja);
            stmt.setInt(2, this.idMision);
            stmt.setString(3, this.fechaInicio);
            stmt.setString(4, this.fechaFin);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}