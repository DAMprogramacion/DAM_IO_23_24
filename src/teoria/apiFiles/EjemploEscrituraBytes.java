package teoria.apiFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class EjemploEscrituraBytes {
    public static void main(String[] args) {
        //static Path 	write(Path path, byte[] bytes, OpenOption... options)
        Path ouPath = Path.of("ficheros/salida/ejemplo4.txt");
        String frase = "Esto es una frase de prueba\nIncluimos un salto de línea";
        try {
            Files.write(ouPath, frase.getBytes(), StandardOpenOption.CREATE);
            System.out.printf("Copiado %d bytes%n", frase.getBytes().length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        };
    }
}
