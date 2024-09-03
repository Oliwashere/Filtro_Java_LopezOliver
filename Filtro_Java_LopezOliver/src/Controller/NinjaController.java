package Controller;

import Model.Ninja;
import java.sql.Connection;
import java.util.Scanner;

public class NinjaController {
    public static void registrarNinja(Scanner scanner, Connection connection) {
        System.out.println("¿Cual es el nombre del Ninja?");
        String nombre = scanner.nextLine();

        System.out.println("¿Que rango es?");
        String rango = scanner.nextLine();

        System.out.println("¿De que aldea viene?");
        String aldea = scanner.nextLine();

        Ninja ninja = new Ninja(0, nombre, rango, aldea);
        ninja.saveToDatabase(connection);
    }
}
