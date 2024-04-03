package ejercicios.ejercicio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

//PARA FICHERO DE TEXTO USO LA CLASE Files Y EL MÉTODO readAllLines
public class AnalisisQuijote {
    public static void main(String[] args) {
        //creo contadores
        int contadorQuijote = 0, contadorSancho = 0, contadorCardenio =0 , contadorDulcinea = 0;
        int contadorRucio = 0, contadorRocinante = 0, contadorFierabras =0 , contadorBarataria = 0;
        int contadorHamete = 0;

        //leer el fichero con Files
        Path path = Path.of("ficheros/entrada/quijote.txt");
        try {
            List<String> lineas = Files.readAllLines(path);
            //mostrar en consola las líneas
           // lineas.forEach(System.out::println);  //para las colecciones
            //recorremos la lista y si contiene, por ejemplo Quijote incrementamos un contador
            for(String linea  :  lineas) {
                /*if (linea.toLowerCase().contains("quijote")) //NO FUNCIONA
                    contadorQuijote++;*/ //No funciona porque si aparece dos veces en la misma línea, solo cuanta una vez
                String[] palabras = linea.split("[ \\s]+"); //divido cada línea en palabras
                for(String palabra : palabras) {
                    if (palabra.toLowerCase().contains("quijote")) //contamos si la palabra está acompañada con una coma, punto, etc
                        contadorQuijote++;
                    if (palabra.toLowerCase().contains("sancho")) //contamos si la palabra está acompañada con una coma, punto, etc
                        contadorSancho++;
                    if (palabra.toLowerCase().contains("cardenio")) //contamos si la palabra está acompañada con una coma, punto, etc
                        contadorCardenio++;
                    if (palabra.toLowerCase().contains("dulcinea")) //contamos si la palabra está acompañada con una coma, punto, etc
                        contadorDulcinea++;
                    if (palabra.toLowerCase().contains("rucio")) //contamos si la palabra está acompañada con una coma, punto, etc
                        contadorRucio++;
                    if (palabra.toLowerCase().contains("rocinante")) //contamos si la palabra está acompañada con una coma, punto, etc
                        contadorRocinante++;
                    if (palabra.toLowerCase().contains("firebrás")) //contamos si la palabra está acompañada con una coma, punto, etc
                        contadorFierabras++;
                    if (palabra.toLowerCase().contains("barataria")) //contamos si la palabra está acompañada con una coma, punto, etc
                        contadorBarataria++;
                    if (palabra.toLowerCase().contains("hamete")) //contamos si la palabra está acompañada con una coma, punto, etc
                        contadorHamete++;
                }
            }
        } catch (IOException e) {
            System.err.println("No existe el fichero: " + e.getMessage());
        }
        //System.out.println(contadorQuijote);
        //MOSTRAMOS EL INFORME, USAMOS UN STRINGBUILDER

    }
}
