package examen;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Generico<String, Number> generico1 =
                new Generico<>("hola", 2);
        generico1.setAtributo2(3);
        System.out.println(generico1);

        Generico<String, String> generico2 =
                new Generico<>("hola", "pepito");
        generico2.setAtributo2("gabriel");
        System.out.println(generico2);
        List<Float> lista = List.of(2.2f, 1.1f);
        System.out.println(Generico.calcularSuma(lista));
    }
}
