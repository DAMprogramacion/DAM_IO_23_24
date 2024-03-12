package teoria.entrada.caracteres;

import java.io.*;
import java.util.Arrays;

public class AnalisFichero {
    public static void main(String[] args) {
        File inFile = new File("ficheros/salida/ejemplo2.txt");
        try (BufferedReader inReader = new BufferedReader(new FileReader(inFile))) {
            int contadorLinea = 0;
            int contadorPalabras = 0;
            String linea = inReader.readLine();
            while (linea != null) {
                String[] tokens = linea.split("[\\s\n]+");
                System.out.println(Arrays.toString(tokens) + "-" + tokens.length);
                contadorPalabras += tokens.length;
                if (!linea.isEmpty())
                    contadorLinea++;
                linea = inReader.readLine();
            }
            System.out.printf("Nº líneas: %d%n", contadorLinea);
            System.out.printf("Nº palabra: %d%n", contadorPalabras);

        } catch (IOException e) {
            System.err.println(e.getMessage());
            ;
        }
    }
}
