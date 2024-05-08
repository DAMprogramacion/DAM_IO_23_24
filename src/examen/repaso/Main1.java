package examen.repaso;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main1 {
    public static void main(String[] args) {
        Path outPath = Paths.get("ficheros/salida/repaso.txt");
        String datos = generarDatos();
        try {
            Files.writeString(outPath, datos, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.printf("Escritos %d bytes en el fichero %s%n",
                    outPath.toFile().length(), outPath);
            List<String> lineas = Files.readAllLines(outPath);
            float media = calcularValorMedio(lineas);
            System.out.printf("Valor medio %.3f%n", media);
        } catch (IOException e) {
            System.err.println("No puedo escribir el fichero");
        }

    }

    private static float calcularValorMedio(List<String> lineas) {
        float suma = 0.0f;
        for (String linea : lineas) {
            String[] tokens = linea.split(" ");
            suma += Float.parseFloat(tokens[1]);
        }
        return suma / lineas.size();
    }

    private static String generarDatos() {
        //1.- 0.1234
        //2.- 0.2555
        //...........
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            builder.append(i).append(".- ").append(new Random().nextFloat()).append('\n');
        }
        return builder.toString().substring(0, builder.length() -1);
    }
}
