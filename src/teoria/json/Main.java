package teoria.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        Gson gson = new Gson();
        try (Reader reader = Files.newBufferedReader(
                Paths.get("ficheros/entrada/personas.json"))) {
            personas = gson.fromJson(reader, new TypeToken<List<Persona>>() {}.getType());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        personas.forEach(System.out::println);
    }
}
