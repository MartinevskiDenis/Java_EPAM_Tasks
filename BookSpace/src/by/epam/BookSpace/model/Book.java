package by.epam.BookSpace.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Book {
    private String name;
    private int authorID;
    private int seriesID;
    private ArrayList<String> genres;
    private Date releaseDate;
    private int cntSymbols;
    private String discription;
    private int id;

    public Book() {
        this.name = "";
        this.authorID = 0;
        this.seriesID = 0;
        this.genres = new ArrayList<String>();
        this.releaseDate = new Date(0, 0, 0);
        this.cntSymbols = 0;
        this.discription = "";
        this.id = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public int getSeriesID() {
        return seriesID;
    }

    public void setSeriesID(int seriesID) {
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

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{ ");
        sb.append("name=").append(name);
        sb.append(", authorID=").append(authorID);
        sb.append(", seriesID=").append(seriesID);
        sb.append(", genres=").append(genres);
        sb.append(", releaseDate=").append(releaseDate);
        sb.append(", cntSymbols=").append(cntSymbols);
        sb.append(", discription=").append(discription);
        sb.append(", id=").append(id);
        sb.append(" }");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return authorID == book.authorID &&
                seriesID == book.seriesID &&
                cntSymbols == book.cntSymbols &&
                id == book.id &&
                name.equals(book.name) &&
                genres.equals(book.genres) &&
                releaseDate.equals(book.releaseDate) &&
                discription.equals(book.discription);

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, authorID, seriesID, genres, releaseDate, cntSymbols, discription, id);
    }
}