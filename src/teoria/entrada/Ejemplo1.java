package teoria.entrada;

import java.io.*;

public class Ejemplo1 {
    public static void main(String[] args) {
        File inFile = new File("ficheros/salida/ejemplo3.txt");
        try (BufferedInputStream inputStream = new BufferedInputStream(
                new FileInputStream(inFile))) {
            /*int bytes = inputStream.read();
            System.out.println((char) bytes);
            bytes = inputStream.read();
            System.out.println((char) bytes);*/
            int bytes = inputStream.read();
            System.out.println((char) bytes);
            while (bytes != -1){
                bytes = inputStream.read();
                System.out.println((char) bytes);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Fin de programa");
    }
}
