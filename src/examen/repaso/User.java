package examen.repaso;

import java.util.Objects;

public record User(String firstName, String lastName, String email) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public String toString() {
        return String.format("%S,%S,%S", email, lastName, firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }
}
//first_name,last_name,email