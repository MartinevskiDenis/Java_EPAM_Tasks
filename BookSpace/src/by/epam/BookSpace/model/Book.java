package by.epam.BookSpace.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Book implements Serializable {
    private static final long serialVersionUID = -7694885217448990056L;
    private String name;
    ArrayList<UUID> authorsID;
    private UUID seriesID;
    private ArrayList<String> genres;
    private Date releaseDate;
    private int cntSymbols;
    private String description;
    private UUID id;

    public Book() {
        this.name = "";
        this.authorsID = new ArrayList<UUID>();
        this.seriesID = UUID.fromString("");
        this.genres = new ArrayList<String>();
        this.releaseDate = new Date(0, 0, 0);
        this.cntSymbols = 0;
        this.description = "";
        this.id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<UUID> getAuthorsID() {
        return authorsID;
    }

    public void setAuthorsID(ArrayList<UUID> authorsID) {
        this.authorsID = new ArrayList<UUID>(authorsID);
    }

    public UUID getSeriesID() {
        return seriesID;
    }

    public void setSeriesID(UUID seriesID) {
        this.seriesID = seriesID;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = new ArrayList<String>(genres);
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = new Date(releaseDate.toString());
    }

    public int getCntSymbols() {
        return cntSymbols;
    }

    public void setCntSymbols(int cntSymbols) {
        this.cntSymbols = cntSymbols;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{ ");
        sb.append("name=").append(name);
        sb.append(", authorsID=").append(authorsID);
        sb.append(", seriesID=").append(seriesID);
        sb.append(", genres=").append(genres);
        sb.append(", releaseDate=").append(releaseDate);
        sb.append(", cntSymbols=").append(cntSymbols);
        sb.append(", description=").append(description);
        sb.append(", id=").append(id);
        sb.append(" }");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return seriesID == book.seriesID &&
                cntSymbols == book.cntSymbols &&
                name.equals(book.name) &&
                authorsID.equals(book.authorsID) &&
                genres.equals(book.genres) &&
                releaseDate.equals(book.releaseDate) &&
                description.equals(book.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, authorsID, seriesID, genres, releaseDate, cntSymbols, description);
    }
}