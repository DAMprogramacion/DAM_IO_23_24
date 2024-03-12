package teoria.salida.caractares;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Ejemplo1 {
    public static void main(String[] args) {
        String[] nombres = {"juan", "alberto", "santiago", "luisa", "esther"};
        int[]    edad    = {23, 45, 21, 19, 51};
        //fichero escribimos :
        //NOMBRE: juan, EDAD: 23
        //NOMBRE: alberto EDAD: 45
        //........
        //comprobamos que ambos array tienen el mismo tamaño,
        //si no, recorremos el de menor tamaño
        int menorTamanno = nombres.length;
        if (edad.length < nombres.length)
            menorTamanno = edad.length;

        //creamos los flujos de salida de tipo caracter (fichero texto)
        File outFile = new File("ficheros/salida/nombreEdad.txt");
        try (PrintWriter out = new PrintWriter(outFile)) {
            for (int i = 0; i < menorTamanno; i++) {
                out.printf("NOMBRE: %s, EDAD: %d%n", nombres[i], edad[i]);
            }
            out.flush();
            System.out.printf("Escrito fichero %s de %d bytes%n", outFile, outFile.length());
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }

    }
}
