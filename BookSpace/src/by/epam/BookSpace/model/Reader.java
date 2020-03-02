package by.epam.BookSpace.model;

import java.util.ArrayList;

public class Reader extends User {
    private boolean isAuthor;
    private ArrayList<Integer> finishedBooks;
    private ArrayList<Integer> startedBooks;
    private ArrayList<Integer> deferredBooks;

    public Reader() {
        super();
        this.isAuthor = false;
        this.finishedBooks = new ArrayList<Integer>();
        this.startedBooks = new ArrayList<Integer>();
        this.deferredBooks = new ArrayList<Integer>();
    }

    public boolean isAuthor() {
        return isAuthor;
    }

    public void setAuthor(boolean author) {
        isAuthor = author;
    }

    public ArrayList<Integer> getFinishedBooks() {
        return finishedBooks;
    }

    public void setFinishedBooks(ArrayList<Integer> finishedBooks) {
        this.finishedBooks = new ArrayList<Integer>(finishedBooks);
    }

    public ArrayList<Integer> getStartedBooks() {
        return startedBooks;
    }

    public void setStartedBooks(ArrayList<Integer> startedBooks) {
        this.startedBooks = new ArrayList<Integer>(startedBooks);
    }

    public ArrayList<Integer> getDeferredBooks() {
        return deferredBooks;
    }

    public void setDeferredBooks(ArrayList<Integer> deferredBooks) {
        this.deferredBooks = new ArrayList<Integer>(deferredBooks);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Reader{ ");
        sb.append(super.toString());
        sb.append("isAuthor=").append(isAuthor);
        sb.append(", finishedBooks=").append(finishedBooks);
        sb.append(", startedBooks=").append(startedBooks);
        sb.append(", deferredBooks=").append(deferredBooks);
        sb.append(" }");
        return sb.toString();
    }
}