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
                    if (palabra.toLowerCase().contains("fierabrás")) //contamos si la palabra está acompañada con una coma, punto, etc
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
        StringBuilder builder = new StringBuilder("Quijote protagonista de la novela, aparece ");
        builder.append(contadorQuijote).append(" veces.\n");
        builder.append("Sancho el fiel escudero, aparece ").append(contadorSancho)
                .append(" veces.\n");
        builder.append("Cardenio personaje al que Don Quijote y Sancho Panza se encontraron cuando iban por un bosque de Sierra Morena. Aparece ")
                .append(contadorCardenio).append(" veces.\n");
        builder.append("Dulcinea la dama de quien está enamorado el protagonista Don Qujote en la novela, aparece ")
                .append(contadorDulcinea).append(" veces mencionada.\n");
        builder.append("Rucio el burro de Sancho Panza, aparece ").append(contadorRucio)
                .append(" veces mencionado.\n");
        builder.append("Rocinante el caballo de Don Quijote, mencionado ").append(contadorRocinante)
                .append(" .\n");
        builder.append("Fierabrás según Don Quijote, poción mágica capaz de curar todas las dolencias del cuerpo humano, mencionado ")
                .append(contadorFierabras).append(" veces.\n");
        builder.append("Barataria ı́nsula de quien fue gobernador Sancho Panza. ")
                .append(contadorBarataria).append(" apariciones.\n");
        builder.append("Hamete supuesto historiador musulmán, ").append(contadorHamete)
                .append(" apariciones.");
        System.out.println(builder);





    }
}
