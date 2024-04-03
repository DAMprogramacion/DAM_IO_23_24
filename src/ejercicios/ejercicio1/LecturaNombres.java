package ejercicios.ejercicio1;
//PARA ESCRIBIR TESTO USO LA CLASE Files Y EL  MÉTODO WriteString
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Random;
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
        //para guardar los nombres
        StringBuilder builder = new StringBuilder();
        String sNumero = "";
        do {
            System.out.println("Introduce número de nombres a obtener");
            System.out.printf("Máximo valor: %d%n", nombres.size());
            sNumero = sc.nextLine();
        } while (! sNumero.matches("[1-9][0-9]*") || //debe ser un número entero, no vale el cero
                Integer.parseInt(sNumero) > nombres.size()); //inferior al tamaño de la lista
        for (int i = 0; i < Integer.parseInt(sNumero); i++) {
            //System.out.println(nombres.get(i));
            builder.append(nombres.get(i)).append('\n'); //añadimos los nombres al builder
        }
        //System.out.println(builder.toString());
        String nombreFichero = String.format("personas_%s.txt", sNumero); //nombre del fichero
        Path path = Paths.get("ficheros", "salida", nombreFichero); //creamos el path a guardar
        String datos = builder.toString().substring(0, builder.toString().length() - 1); //quitamos el último salto de línea
        try {
            Files.writeString(path, datos, StandardOpenOption.CREATE_NEW); //CREATE_NEW crea si ya NO existe
        } catch (IOException e) {
            System.err.println("Ya existe el fichero: " + e.getMessage()); //decimos que el fichero existe
        }
    }

    private static void obtenerNombre() {
        //nombres.clear();
        if (nombres.size() < 1){
            System.out.println("Lista vacía");
            return;
        }

        Random random = new Random();
        int posicion = random.nextInt(nombres.size());
        String nombre = nombres.get(posicion);
        System.out.println(nombre);
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
