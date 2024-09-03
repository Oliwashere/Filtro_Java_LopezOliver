package View;

/*import Controller.MisionController;*/
import Model.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MisionView {
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
            System.out.println("                 Gestión de Misiones");
            System.out.println(PURPLE+"╰─"+YELLOW+"..★."+PURPLE+"────────────────────────────────────────────────╯"+RESET);
            System.out.println("");
            System.out.println("1. Registar Ninja");
            System.out.println("2. Ver Ninjas");
            System.out.println(RED+"3. Exit"+RESET);
            System.out.println("");
            System.out.println(PURPLE+"╰─────────────────────────────────────────────────────╯"+RESET);
            System.out.println("");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    /*MisionController.registrarMision(scanner, dbConnection.getConnection());*/
                    return;
                case 2:
                    verMisiones(dbConnection.getConnection());
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public static void verMisiones(Connection connection) {
        try {
        final String RESET = "\033[0m";
        final String RED = "\033[31m";
        final String GREEN = "\033[32m";
        final String YELLOW = "\033[33m";
        final String BLUE = "\033[34m";
        final String PURPLE = "\033[35m";
            String query = "SELECT * FROM Ninja";
            String query2 = "SELECT * FROM Habilidad";
            Statement statement = connection.createStatement();
            Statement statement2 = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ResultSet resultSet2 = statement2.executeQuery(query2);

            System.out.println("Ninjas registrados:");
            System.out.println("");
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String nombre = resultSet.getString("Nombre");
                String rango = resultSet.getString("Rango");
                String aldea = resultSet.getString("Aldea");
                
                System.out.println("═══════════ ◈ ═══════════");
                System.out.println("");
                System.out.println("ID: " +BLUE+ id+RESET);
                System.out.println("Nombre: " +BLUE+ nombre +RESET);
                System.out.println("Rango: " +BLUE+ rango+RESET);
                System.out.println("Aldea: " +BLUE+ aldea+RESET);
                System.out.println("");
                System.out.println("═════════════════════════");
                System.out.println("");
                System.out.println("═══════════ ◈ ═══════════");
                System.out.println("Habilidades:");
                System.out.println("");
            while (resultSet2.next()) {
                String nombre2 = resultSet2.getString("Nombre"); 
                System.out.println(BLUE+nombre2+RESET);
                System.out.println("");
            }
            resultSet2.close();
            statement2.close();
                System.out.println("═════════════════════════");
                System.out.println("");
                System.out.println("· · ────── ·𖥸· ────── · ·· · ────── ·𖥸· ────── · ·· · ────── ·?· ────── · ·");
                System.out.println("");
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error manito: " + e.getMessage());
        }
    }
}
