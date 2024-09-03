package View;

import Controller.HabilidadController;
import Model.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class HabilidadView {
    public static void display(Scanner scanner, DatabaseConnection dbConnection) {
        while (true) {
            final String RESET = "\033[0m";
            final String RED = "\033[31m";
            final String GREEN = "\033[32m";
            final String YELLOW = "\033[33m";
            final String BLUE = "\033[34m";
            final String PURPLE = "\033[35m";
            System.out.println("");
            System.out.println(PURPLE+"╭────────────────────────────────────────────────"+YELLOW+".★.."+PURPLE+"─╮"+RESET);
            System.out.println("                 Gestión de Habilidades");
            System.out.println(PURPLE+"╰─"+YELLOW+"..★."+PURPLE+"────────────────────────────────────────────────╯"+RESET);
            System.out.println("");
            System.out.println("1. Registar Habilidad");
            System.out.println("2. Ver habilidades");
            System.out.println(RED+"3. Exit"+RESET);
            System.out.println("");
            System.out.println(PURPLE+"╰─────────────────────────────────────────────────────╯"+RESET);
            System.out.println("");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    HabilidadController.registrarHabilidad(scanner, dbConnection.getConnection());
                    return;
                case 2:
                    verHabilidades(dbConnection.getConnection());
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Pero ponga la que es hermano");
            }
        }
    }
    public static void verHabilidades(Connection connection) {
        try {
        final String RESET = "\033[0m";
        final String RED = "\033[31m";
        final String GREEN = "\033[32m";
        final String YELLOW = "\033[33m";
        final String BLUE = "\033[34m";
        final String PURPLE = "\033[35m";
            String query = "SELECT * FROM Habilidad";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("Habilidades registradas:");
            System.out.println("");
            while (resultSet.next()) {
                String nombre = resultSet.getString("Nombre");
                String descripcion = resultSet.getString("Descripcion");
                int idNinja = resultSet.getInt("ID_Ninja");
                
                System.out.println("═══════════ ◈ ═══════════");
                System.out.println("");
                System.out.println("Nombre: " +BLUE+ nombre +RESET);
                System.out.println("Descripcion: " +BLUE+ descripcion+RESET);
                System.out.println("ID del ninja al que peretenece: " +BLUE+ idNinja+RESET);
                System.out.println("");
                System.out.println("═════════════════════════");
                System.out.println("");
                System.out.println("· · ────── ·𖥸· ────── · ·· · ────── ·𖥸· ────── · ·· · ────── ·𖥸· ────── · ·");
                System.out.println("");
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error manito: " + e.getMessage());
        }
    }
}
