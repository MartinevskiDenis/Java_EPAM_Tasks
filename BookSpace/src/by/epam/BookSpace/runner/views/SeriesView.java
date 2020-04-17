package by.epam.BookSpace.runner.views;

import by.epam.BookSpace.model.Book;
import by.epam.BookSpace.model.Series;
import by.epam.BookSpace.runner.View;
import by.epam.BookSpace.services.file.AuthorFileService;
import by.epam.BookSpace.services.file.BookFileService;
import by.epam.BookSpace.services.file.SeriesFileService;
import by.epam.BookSpace.utils.inputs.SeriesInput;

import java.util.UUID;

public class SeriesView extends View<Series, UUID> {

    public SeriesView() {
        this.service = new SeriesFileService();
        this.inputData = new SeriesInput();
    }

    @Override
    public void add() {
        Series item = inputData.inputItem();
        if (item != null) {
            AuthorFileService authorFileService = new AuthorFileService();
            if (authorFileService.getById(item.getAuthorId()) == null) {
                System.out.println("Некорректные данные");
                System.out.println();
                return;
            }
            if (!service.insert(item)) {
                System.out.println("Такой элемент уже существует");
            }
        } else {
            System.out.println("Некорректные данные");
        }
        System.out.println();
    }

    @Override
    public void change() {
        System.out.print("Введите id: ");
        UUID id = inputData.inputId();
        Series item = service.getById(id);
        if (item != null) {
            AuthorFileService authorFileService = new AuthorFileService();
            if (authorFileService.getById(item.getAuthorId()) == null) {
                System.out.println("Некорректные данные");
                System.out.println();
                return;
            }
            Series newItem = inputData.inputItem();
            service.update(id, newItem);
        } else {
            System.out.println("Некорректные данные");
        }
        System.out.println();
    }

    @Override
    public void delete() {
        System.out.print("Введите id: ");
        UUID id = inputData.inputId();
        Series item = service.getById(id);
        if (item != null) {
            if (service.delete(id)) {
                BookFileService bookFileService = new BookFileService();
                for (Book book : bookFileService.getAll()) {
                    if (book.getSeriesID().equals(id)) {
                        book.setSeriesID(null);
                        bookFileService.update(book.getId(), book);
                    }
                }
            }
        } else {
            System.out.println("Некорректные данные");
        }
        System.out.println();
    }
}
