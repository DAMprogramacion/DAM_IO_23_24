package examen.repaso;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args)  {
        List<User> users = new ArrayList<>();
        //leemos el fichero, con la clase Files:
        Path pathIn  = Path.of("ficheros/entrada/datos_examen.csv");
        Path pathOut = Path.of("ficheros/salida/datos_examen_invertido.csv");
        try {
            List<String> lines = Files.readAllLines(pathIn);
            users = createUsers(lines);
            System.out.printf("Escrito %d bytes en el fichero %s%n",
                    saveInFile(users, pathOut), pathOut.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    //    users.forEach(System.out::println);

    }

    private static long saveInFile(List<User> users, Path pathOut) throws IOException {
        String outString = createFieldsCSV(users);
        Files.writeString(pathOut, outString, StandardOpenOption.CREATE_NEW);
        return pathOut.toFile().length();
    }

    private static String createFieldsCSV(List<User> users) {
        //EMAIL,LAST_NAME,FIRST_NAME
        StringBuilder builder = new StringBuilder("EMAIL,LAST_NAME,FIRST_NAME\n");
        for (User user : users ){
            builder.append(user.toString()).append("\n");
        }
        return builder.toString().substring(0, builder.length() - 1);
    }

    private static List<User> createUsers(List<String> lines) {
        List<User> users = new ArrayList<>();
        for (int i = 1; i < lines.size() ; i++) {
            String[] tokens = lines.get(i).split(",");
            User user = new User(tokens[0], tokens[1], tokens[2]);
            users.add(user);

        }
        return users;
    }
}
