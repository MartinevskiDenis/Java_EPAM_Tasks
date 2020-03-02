package by.epam.BookSpace.model;

import java.util.Objects;

public class Series {
    private String name;
    private String description;
    private int countBooks;
    private int authorId;
    private int id;

    public Series() {
        this.name = "";
        this.description = "";
        this.countBooks = 0;
        this.authorId = 0;
        this.id = 0;
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

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
                id == series.id &&
                name.equals(series.name) &&
                description.equals(series.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, countBooks, authorId, id);
    }
}
