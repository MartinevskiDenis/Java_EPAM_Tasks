package by.epam.BookSpace.model;

import java.io.Serializable;
import java.util.Objects;

public class Admin extends User implements Serializable, Cloneable {
    private static final long serialVersionUID = 7473208613915816277L;

    public Admin() {
        super();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Admin{ ");
        sb.append(super.toString());
        sb.append(" }");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
