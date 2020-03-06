package by.epam.BookSpace.model;

import java.io.Serializable;
import java.util.Objects;

public class Author implements Serializable {
    private String name;
    private String surname;
    private int rating;
    private String description;
    private int id;

    public Author() {
        this.name = "";
        this.surname = "";
        this.rating = 0;
        this.description = "";
        this.id = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Author{ ");
        sb.append("name=").append(name);
        sb.append(", surname=").append(surname);
        sb.append(", rating=").append(rating);
        sb.append(", description=").append(description);
        sb.append(", id=").append(id);
        sb.append(" }");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return rating == author.rating &&
                id == author.id &&
                name.equals(author.name) &&
                surname.equals(author.surname) &&
                description.equals(author.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, rating, description, id);
    }
}
