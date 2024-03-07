package teoria.salida;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejemplo2 {
    public static void main(String[] args) {
        String mensaje = "mensaje a escribir en un fichero\nOtra línea";
        File inFile = new File("ficheros/salida/ejemplo2.txt");
        try (FileOutputStream outputStream = new FileOutputStream(inFile)) {
            outputStream.write(mensaje.getBytes());
            outputStream.flush();
        } catch (FileNotFoundException e) {
            System.err.println("No existe el fichero");;
        } catch (IOException e) {
            System.err.println("Error I/O");;
        }
        System.out.printf("Escrito el fichero: %s, %d bytes%n",
                inFile, inFile.length());
    }
}
