package teoria.apiFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class EjemploBackup {
    public static void main(String[] args) {
        //static Path 	copy(Path source, Path target, CopyOption... options)
        //definir path entrada
        Path inPath = Paths.get("ficheros/entrada/images.jpeg");
        //definir path salida
        Path outPath = Paths.get("ficheros/salida/images_backup_nio.jpeg");
        try {
            Files.copy(inPath, outPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.printf("Copiado fichero: %s con %d bytes%n",
                    outPath, Files.size(outPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
