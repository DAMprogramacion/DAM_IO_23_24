package teoria.entrada.caracteres.claseScanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejemplo1 {
    public static void main(String[] args) {
        String cadena = "hola mundo en java"; //delimeter espacio en blanco
        Scanner sc = new Scanner(cadena);
        String token = sc.next();
        System.out.println(token);
        token = sc.next();
        System.out.println(token);
        while (sc.hasNext())
            System.out.println(sc.next());
        cadena = "manuel,45,avda. andalucía 66,Jaén";
        sc = new Scanner(cadena);
        sc.useDelimiter(",");
        while (sc.hasNext())
            System.out.println(sc.next());
        cadena ="manuel,45,avda. andalucía 66,Jaén\n" +
                "gabriel,25,paseo de la estación 23,Málaga\n" +
                "rocío,77,avda. barcelona,Sevilla";
        System.out.println("============================");
        List<Persona> personas = new ArrayList<>();
        sc = new Scanner(cadena);
        sc.useDelimiter("[,\n]");
        while (sc.hasNext()) {
            Persona persona = new Persona(sc.next(), Integer.parseInt(sc.next()),
                    sc.next(), sc.next());
            personas.add(persona);
        }
        System.out.println(personas);
        sc.close();
    }
}
class Persona {
    private String nombre;
    private int edad;
    private String direccion;
    private String localidad;

    public Persona(String nombre, int edad, String direccion, String localidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", direccion='" + direccion + '\'' +
                ", localidad='" + localidad + '\'' +
                '}';
    }
}
