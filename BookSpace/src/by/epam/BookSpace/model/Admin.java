package by.epam.BookSpace.model;

public class Admin extends User {
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
}
