package by.epam.BookSpace.runner.views;

import by.epam.BookSpace.model.Book;
import by.epam.BookSpace.model.Series;
import by.epam.BookSpace.model.Statistics;
import by.epam.BookSpace.runner.View;
import by.epam.BookSpace.services.BookFilterService;
import by.epam.BookSpace.services.file.AuthorFileService;
import by.epam.BookSpace.services.file.BookFileService;
import by.epam.BookSpace.services.file.SeriesFileService;
import by.epam.BookSpace.services.file.StatisticsFileService;
import by.epam.BookSpace.utils.Parser;
import by.epam.BookSpace.utils.inputs.BookInput;

import java.util.ArrayList;
import java.util.UUID;

public class BookView extends View<Book, UUID> {

    public BookView() {
        this.service = new BookFileService();
        this.inputData = new BookInput();
    }

    @Override
    public void add() {
        Book item = inputData.inputItem();
        if (item != null) {
            SeriesFileService seriesFileService = new SeriesFileService();
            AuthorFileService authorFileService = new AuthorFileService();
            if ((item.getSeriesID() != null) && (seriesFileService.getById(item.getSeriesID()) == null)) {
                System.out.println("Некорректные данные");
                System.out.println();
                return;
            }
            for (UUID authorId : item.getAuthorsID()) {
                if (authorFileService.getById(authorId) == null) {
                    System.out.println("Некорректные данные");
                    System.out.println();
                    return;
                }
            }
            if (!service.insert(item)) {
                System.out.println("Такой элемент уже существует");
            } else {
                if (item.getSeriesID() != null) {
                    UUID id = item.getSeriesID();
                    Series series = seriesFileService.getById(id);
                    series.setCountBooks(series.getCountBooks() + 1);
                    seriesFileService.update(id, series);
                }
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
        Book item = service.getById(id);
        if (item != null) {
            Book newItem = inputData.inputItem();
            SeriesFileService seriesFileService = new SeriesFileService();
            AuthorFileService authorFileService = new AuthorFileService();
            if ((newItem.getSeriesID() != null) && seriesFileService.getById(newItem.getSeriesID()) == null) {
                System.out.println("Некорректные данные");
                System.out.println();
                return;
            }
            for (UUID authorId : newItem.getAuthorsID()) {
                if (authorFileService.getById(authorId) == null) {
                    System.out.println("Некорректные данные");
                    System.out.println();
                    return;
                }
            }
            if (service.update(id, newItem)) {
                if (!item.getSeriesID().equals(newItem.getSeriesID())) {
                    if (item.getSeriesID() != null) {
                        SeriesFileService seriesFileService1 = new SeriesFileService();
                        Series series = seriesFileService.getById(item.getSeriesID());
                        series.setCountBooks(series.getCountBooks() - 1);
                        seriesFileService.update(item.getSeriesID(), series);
                    }
                    if (newItem.getSeriesID() != null) {
                        SeriesFileService seriesFileService1 = new SeriesFileService();
                        Series series = seriesFileService.getById(newItem.getSeriesID());
                        series.setCountBooks(series.getCountBooks() - 1);
                        seriesFileService.update(newItem.getSeriesID(), series);
                    }
                }
            }
        } else {
            System.out.println("Некорректные данные");
        }
        System.out.println();
    }

    @Override
    public void delete() {
        System.out.print("Введите id: ");
        UUID id = inputData.inputId();
        Book item = service.getById(id);
        if (item != null) {
            if (service.delete(id)) {
                if (item.getSeriesID() != null) {
                    SeriesFileService seriesFileService = new SeriesFileService();
                    Series series = seriesFileService.getById(item.getSeriesID());
                    series.setCountBooks(series.getCountBooks() - 1);
                    seriesFileService.update(item.getSeriesID(), series);
                }
                StatisticsFileService statisticsFileService = new StatisticsFileService();
                statisticsFileService.delete(id);
            }
        } else {
            System.out.println("Некорректные данные");
        }
        System.out.println();
    }

    @Override
    public void print() {
        System.out.print("Введите id: ");
        UUID id = inputData.inputId();
        Book item = service.getById(id);
        if (item != null) {
            System.out.println(item);
            StatisticsFileService statisticsFileService = new StatisticsFileService();
            Statistics statistics = statisticsFileService.getById(id);
            if (statistics != null) {
                statistics.setNumberViews(statistics.getNumberViews() + 1);
                statisticsFileService.update(id, statistics);
            }
        } else {
            System.out.println("Некорректные данные");
        }
        System.out.println();
    }

    public void printAllBooksAuthor() {
        System.out.print("Введите id автора: ");
        String str = input.nextLine();
        if (str != null) {
            UUID id = Parser.parseUUID(str);
            if (id != null) {
                BookFilterService bookFilterService = new BookFilterService();
                ArrayList<Book> books = bookFilterService.getAllBooksAuthor(this.service.getAll(), id);
                books.forEach(System.out::println);
            } else {
                System.out.println("Некорректный ввод");
            }
        } else {
            System.out.println("Некорректный ввод");
        }
        System.out.println();
    }

    public void printAllBooksGenre() {
        System.out.print("Введите жанр: ");
        String genre = input.nextLine();
        if (genre != null) {
            BookFilterService bookFilterService = new BookFilterService();
            ArrayList<Book> books = bookFilterService.getAllBooksGenre(this.service.getAll(), genre);
            books.forEach(System.out::println);
        } else {
            System.out.println("Некорректный ввод");
        }
        System.out.println();
    }

    public void printAllBooksSeries() {
        System.out.print("Введите id серии книг: ");
        String str = input.nextLine();
        if (str != null) {
            UUID id = Parser.parseUUID(str);
            if (id != null) {
                BookFilterService bookFilterService = new BookFilterService();
                ArrayList<Book> books = bookFilterService.getAllBooksSeries(this.service.getAll(), id);
                books.forEach(System.out::println);
            } else {
                System.out.println("Некорректный ввод");
            }
        } else {
            System.out.println("Некорректный ввод");
        }
        System.out.println();
    }
}
