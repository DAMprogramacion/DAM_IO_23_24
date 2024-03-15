package teoria.apiFiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Random;

public class EjemploEscrituraCaracteres {
    public static void main(String[] args) {
        Random random = new Random();
        Path inPath = Paths.get("ficheros/entrada/quijote.txt");
        Path outPath = Paths.get("ficheros/salida/quijote_lineas.txt");

        List<String> lineas = null;
        try {
            lineas = Files.readAllLines(inPath);

            /*int lineaMenor = random.nextInt(lineas.size());
            int lineaMayor =  lineaMenor + random.nextInt(lineas.size() - lineaMenor);*/
            int lineaMayor = 0;
            do {
                lineaMayor = random.nextInt(lineas.size());
            } while (lineaMayor == 0);
            int lineaMenor = random.nextInt(lineaMayor);
            StringBuilder builder = new StringBuilder();
            for (int i = lineaMenor; i < lineaMayor; i++) {
                builder.append(lineas.get(i)).append('\n');
            }
            Files.writeString(outPath, builder.toString(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
