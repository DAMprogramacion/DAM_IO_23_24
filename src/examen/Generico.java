package examen;

import java.util.List;

public class Generico <T, V>{
    private T atributo1;
    private V atributo2;

    public Generico(T atributo1, V atributo2) {
        this.atributo1 = atributo1;
        this.atributo2 = atributo2;
    }

    public T getAtributo1() {
        return atributo1;
    }

    public void setAtributo1(T atributo1) {
        this.atributo1 = atributo1;
    }

    public V getAtributo2() {
        return atributo2;
    }

    public void setAtributo2(V atributo2) {
        this.atributo2 = atributo2;
    }

    @Override
    public String toString() {
        return "Generico{" +
                "atributo1=" + atributo1 +
                ", atributo2=" + atributo2 +
                '}';
    }
    public static double calcularSuma(List<? extends Number> lista) {
        double suma = 0.0;
        for (Number number: lista)
            suma += number.doubleValue();
        return suma;
    }
}
