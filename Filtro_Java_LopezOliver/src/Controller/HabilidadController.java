package Controller;

import Model.Habilidad;
import java.sql.Connection;
import java.util.Scanner;

public class HabilidadController {
    public static void registrarHabilidad(Scanner scanner, Connection connection) {
        System.out.println("Ingresa el ID del Ninja a asignar la habilidad");
        int idNinja = scanner.nextInt();
        scanner.nextLine();

        System.out.println("¿Cual es el nombre de la habilidad?");
        String nombre = scanner.nextLine();

        System.out.println("Ingresa una breve descripcion de la habilidad");
        String descripcion = scanner.nextLine();

        Habilidad habilidad = new Habilidad(idNinja, nombre, descripcion);
        habilidad.saveToDatabase(connection);
    }
}
