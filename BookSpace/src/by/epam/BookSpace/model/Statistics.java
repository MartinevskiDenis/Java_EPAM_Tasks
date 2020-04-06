package by.epam.BookSpace.model;

import java.io.Serializable;
import java.util.Objects;

public class Statistics implements Serializable {
    private static final long serialVersionUID = -7647459242435415931L;
    private int numberViews;
    private int numberComments;
    private int numberLikes;
    private int bookId;

    public Statistics() {
        this.numberViews = 0;
        this.numberComments = 0;
        this.numberLikes = 0;
        this.bookId = 0;
    }

    public int getNumberViews() {
        return numberViews;
    }

    public void setNumberViews(int numberViews) {
        this.numberViews = numberViews;
    }

    public int getNumberComments() {
        return numberComments;
    }

    public void setNumberComments(int numberComments) {
        this.numberComments = numberComments;
    }

    public int getNumberLikes() {
        return numberLikes;
    }

    public void setNumberLikes(int numberLikes) {
        this.numberLikes = numberLikes;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Statistics{ ");
        sb.append("numberViews=").append(numberViews);
        sb.append(", numberComments=").append(numberComments);
        sb.append(", numberLikes=").append(numberLikes);
        sb.append(", bookId=").append(bookId);
        sb.append(" }");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statistics that = (Statistics) o;
        return numberViews == that.numberViews &&
                numberComments == that.numberComments &&
                numberLikes == that.numberLikes &&
                bookId == that.bookId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberViews, numberComments, numberLikes, bookId);
    }
}
