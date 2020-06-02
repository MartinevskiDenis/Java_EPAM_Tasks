package by.epam.bookspace.model;

import javax.persistence.*;

@Entity
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne(mappedBy = "statistics")
    private Book book;
    private Integer numberViews;

    public Statistics() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getNumberViews() {
        return numberViews;
    }

    public void setNumberViews(Integer numberViews) {
        this.numberViews = numberViews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Statistics that = (Statistics) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Statistics{");
        sb.append("id=").append(id);
        sb.append(", book=").append(book);
        sb.append(", numberViews=").append(numberViews);
        sb.append('}');
        return sb.toString();
    }
}
