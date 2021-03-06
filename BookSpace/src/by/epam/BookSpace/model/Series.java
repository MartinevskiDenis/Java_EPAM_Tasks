package by.epam.BookSpace.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Series implements Serializable, Cloneable {
    private static final long serialVersionUID = -272059427749322275L;
    private String name;
    private String description;
    private int countBooks;
    private UUID authorId;
    private UUID id;

    public Series() {
        this.name = "";
        this.description = "";
        this.countBooks = 0;
        this.authorId = null;
        this.id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCountBooks() {
        return countBooks;
    }

    public void setCountBooks(int countBooks) {
        this.countBooks = countBooks;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Series{ ");
        sb.append("name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", countBooks=").append(countBooks);
        sb.append(", authorId=").append(authorId);
        sb.append(", id=").append(id);
        sb.append(" }");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Series series = (Series) o;
        return countBooks == series.countBooks &&
                authorId == series.authorId &&
                name.equals(series.name) &&
                description.equals(series.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, countBooks, authorId);
    }
}
