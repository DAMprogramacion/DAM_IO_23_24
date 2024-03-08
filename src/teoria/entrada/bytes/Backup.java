package teoria.entrada.bytes;

import java.io.*;

public class Backup {
    public static void main(String[] args) {
        //definir fichero de entrada : images.jpeg
        String inFile = "ficheros/entrada/images.jpeg";
        //definir fichero de salida  : images_backup.jpeg
        String outFile = obtenerNombreFicheroSalida(inFile);
       // System.out.println(outFile);
        //buffer de entrada y buffer de salida
        try (
                BufferedInputStream inputStream = new BufferedInputStream(
                    new FileInputStream(inFile));
                BufferedOutputStream outputStream = new BufferedOutputStream(
                     new FileOutputStream(outFile))
        ) {
                int bytesLeidos = inputStream.read();
                int contador = 0;
                while (bytesLeidos != -1) {
                    outputStream.write( bytesLeidos );
                    contador++;
                    bytesLeidos = inputStream.read();
                }
                outputStream.flush();
            System.out.printf("Creado fichero %s de %d bytes %n", outFile, contador);
        } catch (IOException e) {
            System.err.println(e.getMessage());;
        }
        //leemos con read hasta que nos encontramos -1
        //una vez leido, escribimos con write
        //sería interesante contar los bytes leídos/escritos
    }

    private static String obtenerNombreFicheroSalida(String inFile) {
        String[] tokens = inFile.split("\\.");
        StringBuilder builder = new StringBuilder(
                tokens[0].replace("entrada", "salida"));
        builder.append("_backup.").append(tokens[1]);
        return builder.toString();
    }


}
