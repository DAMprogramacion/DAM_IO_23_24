package teoria.apiFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class EjemploLecturaCaracteres {
    public static void main(String[] args) {
        //static List<String> 	readAllLines(Path path)
        Path inPath = Paths.get("ficheros/entrada/quijote.txt");
        try {
            List<String> lineas = Files.readAllLines(inPath);
            System.out.printf("El fichero %s tiene %d líneas%n",
                    inPath, lineas.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
