package by.epam.BookSpace.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Reader extends User implements Serializable, Cloneable {
    private static final long serialVersionUID = -1641873701860347305L;
    private boolean isAuthor;
    protected boolean isSubscriber;
    private ArrayList<UUID> finishedBooks;
    private ArrayList<UUID> startedBooks;
    private ArrayList<UUID> deferredBooks;

    public Reader() {
        super();
        this.isAuthor = false;
        this.isSubscriber=false;
        this.finishedBooks = new ArrayList<UUID>();
        this.startedBooks = new ArrayList<UUID>();
        this.deferredBooks = new ArrayList<UUID>();
    }

    public boolean isAuthor() {
        return isAuthor;
    }

    public void setAuthor(boolean author) {
        isAuthor = author;
    }

    public boolean isSubscriber() {
        return isSubscriber;
    }

    public void setSubscriber(boolean subscriber) {
        isSubscriber = subscriber;
    }

    public ArrayList<UUID> getFinishedBooks() {
        return finishedBooks;
    }

    public void setFinishedBooks(ArrayList<UUID> finishedBooks) {
        this.finishedBooks = new ArrayList<UUID>(finishedBooks);
    }

    public ArrayList<UUID> getStartedBooks() {
        return startedBooks;
    }

    public void setStartedBooks(ArrayList<UUID> startedBooks) {
        this.startedBooks = new ArrayList<UUID>(startedBooks);
    }

    public ArrayList<UUID> getDeferredBooks() {
        return deferredBooks;
    }

    public void setDeferredBooks(ArrayList<UUID> deferredBooks) {
        this.deferredBooks = new ArrayList<UUID>(deferredBooks);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Reader{ ");
        sb.append(super.toString());
        sb.append("isAuthor=").append(isAuthor);
        sb.append(", isSubscriber=").append(isSubscriber);
        sb.append(", finishedBooks=").append(finishedBooks);
        sb.append(", startedBooks=").append(startedBooks);
        sb.append(", deferredBooks=").append(deferredBooks);
        sb.append(" }");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Reader reader = (Reader) o;
        return isAuthor == reader.isAuthor &&
                isSubscriber == reader.isSubscriber &&
                finishedBooks.equals(reader.finishedBooks) &&
                startedBooks.equals(reader.startedBooks) &&
                deferredBooks.equals(reader.deferredBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isAuthor, isSubscriber, finishedBooks, startedBooks, deferredBooks);
    }
}