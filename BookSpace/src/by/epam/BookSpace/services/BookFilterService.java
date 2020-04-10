package by.epam.BookSpace.services;

import by.epam.BookSpace.model.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.UUID;

public class BookFilterService {
    protected static final Logger log = LogManager.getLogger();

    public ArrayList<Book> getAllBooksAuthor(ArrayList<Book> allBooks, UUID authorId) {
        ArrayList<Book> books = new ArrayList<>();
        if (authorId != null) {
            for (Book book : allBooks) {
                for (UUID bookAuthorId : book.getAuthorsID()) {
                    if (bookAuthorId == authorId) {
                        books.add(book);
                        break;
                    }
                }
            }
            log.info("Возвращен список книг автора с id=" + authorId.toString());
        } else {
            log.info("Ошибка! В функцию передано значение null");
        }
        return books;
    }

    public ArrayList<Book> getAllBooksGenre(ArrayList<Book> allBooks, String genre) {
        ArrayList<Book> books = new ArrayList<>();
        if (genre != null) {
            for (Book book : allBooks) {
                for (String bookGenre : book.getGenres()) {
                    if (bookGenre.equals(genre)) {
                        books.add(book);
                        break;
                    }
                }
            }
            log.info("Возвращен список книг жанра " + genre);
        } else {
            log.info("Ошибка! В функцию передано значение null");
        }
        return books;
    }

    public ArrayList<Book> getAllBooksSeries(ArrayList<Book> allBooks, UUID seriesId) {
        ArrayList<Book> books = new ArrayList<>();
        if (seriesId != null) {
            for (Book book : allBooks) {
                if (book.getSeriesID() == seriesId) {
                    books.add(book);
                }
            }
            log.info("Возвращен список книг серии с id=" + seriesId.toString());
        } else {
            log.info("Ошибка! В функцию передано значение null");
        }
        return books;
    }
}
