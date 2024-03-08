package teoria.salida.bytes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Ejemplo1 {
    public static void main(String[] args) {
        FileOutputStream outStream = null;
        String outFile = "ficheros/salida/ejemplo1.txt";
        try {
             outStream = new FileOutputStream(outFile, true);
            for (int i = 0; i < 10; i++) {
                int bytes = 97 + new Random().nextInt(30);
                outStream.write(bytes);
            }
            outStream.flush();

        } catch (FileNotFoundException e) {
            System.err.println("No existe el fichero");;
        } catch (IOException e) {
            System.err.println("Error I/O");;
        } finally {
            try {
                if (outStream != null)
                    outStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
