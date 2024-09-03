import View.NinjaView;
import View.MisionView;
import View.HabilidadView;
import Model.DatabaseConnection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseConnection dbConnection = new DatabaseConnection();
        final String RESET = "\033[0m";
        final String RED = "\033[31m";
        final String GREEN = "\033[32m";
        final String YELLOW = "\033[33m";
        final String BLUE = "\033[34m";
        final String PURPLE = "\033[35m";
        
        while (true) {
            System.out.println("");
            System.out.println(BLUE+"╭────────────────────────────────────────────────"+YELLOW+".★.."+BLUE+"─╮"+RESET);
            System.out.println("     Bienvenido al sistema de gestión de Konoha ");
            System.out.println(BLUE+"╰─"+YELLOW+"..★."+BLUE+"────────────────────────────────────────────────╯"+RESET);
            System.out.println("");
            System.out.println("Select a role:");
            System.out.println("");
            System.out.println("1. Ninja");
            System.out.println("2. Habilidad");
            System.out.println("3. Mision");
            System.out.println(RED+"4. Exit"+RESET);
            System.out.println("");
            System.out.println(BLUE+"╰─────────────────────────────────────────────────────╯"+RESET);
            System.out.println("");

            
            int role = scanner.nextInt();
            scanner.nextLine();

            switch (role) {
                case 1:
                    NinjaView.display(scanner, dbConnection);
                    break;
                case 2:
                    HabilidadView.display(scanner, dbConnection);
                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("Largate ome!!");
                    dbConnection.close();
                    scanner.close();
                    return;
                default:
                    System.out.println("Re mal amigo, selecciona del menú hermano");
            }
        }
    }
}