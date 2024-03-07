package teoria.salida;

import java.io.*;

public class Ejemplo3 {
    public static void main(String[] args) {
        String mensaje = "mensaje a escribir \ten un fichero\nOtra línea";
        byte[] bytesMensaje = mensaje.getBytes();
        File inFile = new File("ficheros/salida/ejemplo3.txt");
        try (BufferedOutputStream outputStream = new BufferedOutputStream(
                new FileOutputStream(inFile))) {
            outputStream.write(bytesMensaje);
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
