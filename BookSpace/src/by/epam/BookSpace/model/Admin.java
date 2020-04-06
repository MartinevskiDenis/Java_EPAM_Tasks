package by.epam.BookSpace.model;

import java.io.Serializable;
import java.util.Objects;

public class Admin extends User implements Serializable {
    private static final long serialVersionUID = 607562200082274002L;
    private final boolean isAdmin = true;

    public Admin() {
        super();
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Admin{ ");
        sb.append(super.toString());
        sb.append("isAdmin=").append(isAdmin);
        sb.append(" }");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Admin admin = (Admin) o;
        return isAdmin == admin.isAdmin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isAdmin);
    }
}
