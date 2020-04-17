package by.epam.BookSpace.runner.views;

import by.epam.BookSpace.model.*;
import by.epam.BookSpace.runner.View;
import by.epam.BookSpace.services.CommentFilterService;
import by.epam.BookSpace.services.file.*;
import by.epam.BookSpace.utils.Parser;
import by.epam.BookSpace.utils.inputs.CommentInput;

import java.util.ArrayList;
import java.util.UUID;

public class CommentView extends View<Comment, UUID> {

    public CommentView() {
        this.service = new CommentFileService();
        this.inputData = new CommentInput();
    }

    @Override
    public void add() {
        Comment item = inputData.inputItem();
        if (item != null) {
            ReaderFileService readerFileService = new ReaderFileService();
            AdminFileService adminFileService = new AdminFileService();
            BookFileService bookFileService = new BookFileService();
            if (((readerFileService.getById(item.getUserLogin()) == null) && (adminFileService.getById(item.getUserLogin()) == null)) || (bookFileService.getById(item.getBookId()) == null)) {
                System.out.println("Некорректные данные");
                System.out.println();
                return;
            }
            if (!service.insert(item)) {
                System.out.println("Такой элемент уже существует");
            } else {
                StatisticsFileService statisticsFileService = new StatisticsFileService();
                Statistics statistics = statisticsFileService.getById(item.getBookId());
                if (statistics != null) {
                    statistics.setNumberComments(statistics.getNumberComments() + 1);
                    statisticsFileService.update(statistics.getBookId(), statistics);
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
        Comment item = service.getById(id);
        if (item != null) {
            ReaderFileService readerFileService = new ReaderFileService();
            AdminFileService adminFileService = new AdminFileService();
            BookFileService bookFileService = new BookFileService();
            if (((readerFileService.getById(item.getUserLogin()) == null) && (adminFileService.getById(item.getUserLogin()) == null)) || (bookFileService.getById(item.getBookId()) == null)) {
                System.out.println("Некорректные данные");
                System.out.println();
                return;
            }
            Comment newItem = inputData.inputItem();
            if (service.update(id, newItem)) {
                if (!item.getBookId().equals(newItem.getBookId())) {
                    StatisticsFileService statisticsFileService = new StatisticsFileService();
                    Statistics statistics = statisticsFileService.getById(item.getBookId());
                    if (statistics != null) {
                        statistics.setNumberComments(statistics.getNumberComments() - 1);
                        statisticsFileService.update(item.getBookId(), statistics);
                    }
                    statistics = statisticsFileService.getById(newItem.getBookId());
                    if (statistics != null) {
                        statistics.setNumberComments(statistics.getNumberComments() + 1);
                        statisticsFileService.update(newItem.getBookId(), statistics);
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
        Comment item = service.getById(id);
        if (item != null) {
            if (service.delete(id)) {
                StatisticsFileService statisticsFileService = new StatisticsFileService();
                Statistics statistics = statisticsFileService.getById(item.getBookId());
                if (statistics != null) {
                    statistics.setNumberComments(statistics.getNumberComments() - 1);
                    statisticsFileService.update(item.getBookId(), statistics);
                }
            }
        } else {
            System.out.println("Некорректные данные");
        }
        System.out.println();
    }

    public void addCommentUser(String login) {
        Comment comment = ((CommentInput) inputData).inputItemUser();
        if (comment != null) {
            comment.setUserLogin(login);
            BookFileService bookFileService = new BookFileService();
            if (bookFileService.getById(comment.getBookId()) == null) {
                System.out.println("Некорректные данные");
                System.out.println();
                return;
            }
            if (service.insert(comment)) {
                StatisticsFileService statisticsFileService = new StatisticsFileService();
                Statistics statistics = statisticsFileService.getById(comment.getBookId());
                if (statistics != null) {
                    statistics.setNumberComments(statistics.getNumberComments() + 1);
                    statisticsFileService.update(statistics.getBookId(), statistics);
                }
            }
        } else {
            System.out.println("Некорректные данные");
        }
        System.out.println();
    }

    public void changeCommentUser(String login) {
        System.out.print("Введите id комментария: ");
        String str = input.nextLine();
        if (str != null) {
            UUID id = Parser.parseUUID(str);
            if (id != null) {
                Comment comment = this.service.getById(id);
                if (comment != null) {
                    if (comment.getUserLogin().equals(login)) {
                        String newText = ((CommentInput) this.inputData).inputText();
                        if (newText != null) {
                            comment.setText(newText);
                            this.service.update(id, comment);
                        } else {
                            System.out.println("Некорректный ввод");
                        }
                    } else {
                        System.out.println("Нельзя удалить чужой комментарий");
                    }
                } else {
                    System.out.println("Некорректный ввод");
                }
            } else {
                System.out.println("Некорректный ввод");
            }
        } else {
            System.out.println("Некорректный ввод");
        }
        System.out.println();
    }

    public void deleteCommentUser(String login) {
        System.out.print("Введите id комментария: ");
        String str = input.nextLine();
        if (str != null) {
            UUID id = Parser.parseUUID(str);
            if (id != null) {
                Comment comment = this.service.getById(id);
                if (comment != null) {
                    if (comment.getUserLogin().equals(login)) {
                        if (this.service.delete(id)) {
                            StatisticsFileService statisticsFileService = new StatisticsFileService();
                            Statistics statistics = statisticsFileService.getById(comment.getBookId());
                            if (statistics != null) {
                                statistics.setNumberComments(statistics.getNumberComments() - 1);
                                statisticsFileService.update(comment.getBookId(), statistics);
                            }
                        }
                    } else {
                        System.out.println("Нельзя удалить чужой комментарий");
                    }
                } else {
                    System.out.println("Некорректный ввод");
                }
            } else {
                System.out.println("Некорректный ввод");
            }
        } else {
            System.out.println("Некорректный ввод");
        }
        System.out.println();
    }

    public void printAllBookComments() {
        System.out.print("Введите id книги: ");
        String str = input.nextLine();
        if (str != null) {
            UUID id = Parser.parseUUID(str);
            if (id != null) {
                CommentFilterService commentFilterService = new CommentFilterService();
                ArrayList<Comment> comments = commentFilterService.getAllBookComments(this.service.getAll(), id);
                comments.forEach(System.out::println);
            } else {
                System.out.println("Некорректный ввод");
            }
        } else {
            System.out.println("Некорректный ввод");
        }
        System.out.println();
    }
}
