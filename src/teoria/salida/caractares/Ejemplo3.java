package teoria.salida.caractares;

import java.io.*;
import java.util.Scanner;

public class Ejemplo3 {
    public static void main(String[] args) {
        //.NumberFormatException
        final int NUMERO_TOTAL_LINEAS = 2_186;
        final int NUMERO_MINIMO_LINEAS = 10;
        final int NUMERO_MAXIMO_LINEAS = 100;
        final int LINEA_MINIMA_COPIAR = 5;
        final String DIRECTORIO_SALIDA = "ficheros/salida/";
        File inFile = new File("ficheros/entrada/quijote.txt");
        //comprobamos que existe el fichero ficheros/entrda/quijote.txt
        //si no existe, termina el programa con mensaje
        if (! inFile.exists()) {
            System.out.println("No existe el fichero fuente");
            return;
        }
        Scanner sc = new Scanner(System.in);
        //Solicite por Scanner el nº de líneas a copiar del Quijote
        //comprobar que el nº líneas solicitadas sea mínimo 5 y máximo 2186,
        //no continuamos hasta que esté en ese rango
        String sNumeroLinea = "0";
        int iNumeroLineaDondeEmpezar = 0;
        do {
            System.out.println("Introduce la primera línea a copiar ");
            sNumeroLinea = sc.nextLine();
            try {
                iNumeroLineaDondeEmpezar = Integer.parseInt(sNumeroLinea);
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage() + " Valor no válido");
            }
        } while (iNumeroLineaDondeEmpezar < LINEA_MINIMA_COPIAR || iNumeroLineaDondeEmpezar > NUMERO_TOTAL_LINEAS);
        //solicitamos el nº de líneas a copiar, mínimo 10 y máximo 100
        String sNumeroLineas = "0";
        int iNumeroLineasACopiar = 0;
        do {
            System.out.println("Introduce nº de líneas a copiar (10-100 inclusive)");
            sNumeroLineas = sc.nextLine();
            try {
                iNumeroLineasACopiar = Integer.parseInt(sNumeroLineas);
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage() + " Valor no válido");
            }
        } while (iNumeroLineasACopiar < NUMERO_MINIMO_LINEAS || iNumeroLineasACopiar > NUMERO_MAXIMO_LINEAS
                || (iNumeroLineasACopiar + iNumeroLineaDondeEmpezar) > NUMERO_TOTAL_LINEAS );
        sc.close();

        //Creamos el nombre del fichero
        //ficheroSalida tiene el nombre: ficheros/salida/quijote5_10.txt
        // copiado 10 líneas empezando en la línea 5

        StringBuilder builder = new StringBuilder(DIRECTORIO_SALIDA);
        builder.append("quijote").append(iNumeroLineaDondeEmpezar).append('_');
        builder.append(iNumeroLineasACopiar).append(".txt");
        File outFile = new File(builder.toString());

        try (
                Scanner in = new Scanner(inFile);
                PrintWriter out   = new PrintWriter(outFile);
        ) {
            //leemos hasta la primera línea y la ignoramos:
            for (int i = 0; i < iNumeroLineaDondeEmpezar; i++) {
                System.err.println(++i + ": IGNORANDO: " + in.nextLine());
            }
            for (int i = 1; i < iNumeroLineasACopiar + 1; i++) {
                //se escribe el fichero y damos mensaje con los bytes creados
                //formato fichero:
                //LÍNEA 1: .....
                //LÍNEA 2: ......
                out.printf("LÍNEA %d: %s%n", i, in.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        System.out.printf("Escritos el fichero %s con %d bytes%n", outFile, outFile.length());
    }
}
