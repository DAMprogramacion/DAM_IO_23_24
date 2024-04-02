package ejercicios.ejercicio1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class LecturaNombres {
    private static Scanner sc = new Scanner(System.in);
    private static List<String> nombres;
    public static void main(String[] args) {
        nombres = cargarNombres();
        mostrarMenu();
    }

    private static List<String> cargarNombres() {
        List<String> datos = null;
        try {
            datos = Files.readAllLines(Path.of("ficheros/entrada/nombres.txt"));
            System.out.println("Cargado el fichero de nombres\n");
        } catch (IOException e) {
            System.err.println("NO cargado el fichero de nombres\n");
            salir(1);
        }
        return datos;
    }

    private static void mostrarMenu() {
        String opcion = "";
        while (true){
            System.out.println("1. Buscar nombre");
            System.out.println("2. Obtener nombre");
            System.out.println("3. Guardar nombres");
            System.out.println("4. Salir");
            System.out.println("\nIntroduce opción");
            opcion = sc.nextLine();
            switch (opcion){
                case "1" -> buscarNombre();
                case "2" -> obtenerNombre();
                case "3" -> guardarNombre();
                case "4" -> salir(0);
                default -> System.err.println("opción no válida");
            }
        }
    }

    private static void salir(int status) {
        System.out.println("Cerrando el programa....");
        sc.close();
        System.exit(status);
    }

    private static void guardarNombre() {
    }

    private static void obtenerNombre() {
    }

    private static void buscarNombre() {
        System.out.println("\nIntroduce el nombre a buscar");
        String nombre = sc.nextLine();
        if (nombres.contains(nombre))
            System.out.printf("Existe el nombre: %S%n", nombre);
        else
            System.out.printf("NO existe el nombre: %S%n", nombre);
    }
}
