package teoria.apiFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EjemploLecturaBytes {
    public static void main(String[] args) {
        //static byte[] 	readAllBytes(Path path)
        //Crear el path de una imagen
        Path inPath = Paths.get("ficheros/entrada/images.jpeg");
        //con Files saber el tamaño del fichero
        try {
            System.out.printf("Tamaño fichero: %s con %d bytes%n",
                    inPath, Files.size(inPath));
            byte[] bytes = Files.readAllBytes(inPath);
            System.out.printf("Leídos %d bytes%n", bytes.length);
           /* System.out.printf("Primer byte: %d", bytes[0]);
            System.out.printf("Último byte; %d", bytes[bytes.length - 1]);*/
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //byte[] saber si su tamaño coincide con el anterior, antes se lee con readAllBytes

    }
}
