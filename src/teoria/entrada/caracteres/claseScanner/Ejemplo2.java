package teoria.entrada.caracteres.claseScanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejemplo2 {
    public static void main(String[] args) {
        double suma = 0;
        int contador = 0;
        File inFile = new File("ficheros/entrada/numbers.txt");
        if (! inFile.exists()) {
            System.out.println("No existe el fichero");
            return;
        }
        try (Scanner in = new Scanner(inFile)) {
            while (in.hasNextDouble()){
              //  System.out.println("leido " + in.nextDouble());  OJO: TÍPICO ERROR
                suma += in.nextDouble();
                contador++;
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        System.out.printf("Leidos %d números, el valor medio es %.2f%n",
                contador, suma / contador);
    }
}
