package by.epam.BookSpace.utils.inputs;

import by.epam.BookSpace.model.Book;
import by.epam.BookSpace.utils.InputData;
import by.epam.BookSpace.utils.Parser;

import java.util.ArrayList;
import java.util.UUID;

public class BookInput extends InputData<Book, UUID> {
    @Override
    public Book inputItem() {
        Book book = new Book();
        System.out.print("Введите название книги: ");
        String str = input.nextLine();
        if (str.equals("")) {
            return null;
        }
        book.setName(str);
        int cnt;
        System.out.print("Введите количество авторов книги: ");
        str = input.nextLine();
        cnt = Parser.parseInteger(str);
        if (cnt <= 0) {
            return null;
        }
        ArrayList<UUID> authorsID = new ArrayList<>();
        for (int i = 0; i < cnt; ++i) {
            System.out.print("Введите id " + String.valueOf(i + 1) + "-ого автора: ");
            str = input.nextLine();
            UUID id = Parser.parseUUID(str);
            if (id != null) {
                if(authorsID.contains(id)) {
                    return null;
                }
                authorsID.add(id);
            } else {
                return null;
            }
        }
        book.setAuthorsID(authorsID);
        System.out.print("Введите id серии книги: ");
        str = input.nextLine();
        if (!str.equals("")) {
            UUID id = Parser.parseUUID(str);
            if (id != null) {
                book.setSeriesID(id);
            } else {
                return null;
            }
        }
        System.out.print("Введите количество жанров книги: ");
        str = input.nextLine();
        cnt = Parser.parseInteger(str);
        if (cnt < 0) {
            return null;
        }
        ArrayList<String> genres = new ArrayList<>();
        for (int i = 0; i < cnt; ++i) {
            System.out.print("Введите " + String.valueOf(i + 1) + "-ый жанр: ");
            str = input.nextLine();
            if (str.equals("")) {
                return null;
            }
            if(genres.contains(str)) {
                return null;
            }
            genres.add(str);
        }
        book.setGenres(genres);
        System.out.print("Введите описание книги: ");
        str = input.nextLine();
        book.setDescription(str);
        return book;
    }

    @Override
    public UUID inputId() {
        String str = input.nextLine();
        UUID id = Parser.parseUUID(str);
        return id;
    }
}
