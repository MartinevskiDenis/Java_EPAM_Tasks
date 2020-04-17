package by.epam.BookSpace.runner.views;

import by.epam.BookSpace.model.Author;
import by.epam.BookSpace.model.Book;
import by.epam.BookSpace.model.Series;
import by.epam.BookSpace.runner.View;
import by.epam.BookSpace.services.file.AuthorFileService;
import by.epam.BookSpace.services.file.BookFileService;
import by.epam.BookSpace.services.file.SeriesFileService;
import by.epam.BookSpace.services.file.StatisticsFileService;
import by.epam.BookSpace.utils.inputs.AuthorInput;

import java.util.ArrayList;
import java.util.UUID;

public class AuthorView extends View<Author, UUID> {

    public AuthorView() {
        this.service = new AuthorFileService();
        this.inputData = new AuthorInput();
    }

    @Override
    public void delete() {
        System.out.print("Введите id: ");
        UUID id = inputData.inputId();
        Author item = service.getById(id);
        if (item != null) {
            if (service.delete(id)) {
                BookFileService bookFileService = new BookFileService();
                ArrayList<Book> books = bookFileService.getAll();
                for (Book book : books) {
                    ArrayList<UUID> authorsID = book.getAuthorsID();
                    if ((authorsID.size() == 1) && (authorsID.get(0).equals(item.getId()))) {
                        if (bookFileService.delete(book.getId())) {
                            if (book.getSeriesID() != null) {
                                SeriesFileService seriesFileService = new SeriesFileService();
                                Series series = seriesFileService.getById(book.getSeriesID());
                                series.setCountBooks(series.getCountBooks() - 1);
                                seriesFileService.update(book.getSeriesID(), series);
                            }
                            StatisticsFileService statisticsFileService = new StatisticsFileService();
                            statisticsFileService.delete(id);
                        }
                    } else {
                        if (authorsID.contains(id)) {
                            authorsID.remove(id);
                            book.setAuthorsID(authorsID);
                            bookFileService.update(book.getId(), book);
                        }
                    }
                }
            }
        } else {
            System.out.println("Некорректные данные");
        }
        System.out.println();
    }
}
