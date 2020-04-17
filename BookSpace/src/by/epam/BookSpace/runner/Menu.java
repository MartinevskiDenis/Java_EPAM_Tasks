package by.epam.BookSpace.runner;

import by.epam.BookSpace.model.Admin;
import by.epam.BookSpace.model.Reader;
import by.epam.BookSpace.runner.views.*;
import by.epam.BookSpace.services.file.AdminFileService;
import by.epam.BookSpace.services.file.ReaderFileService;
import by.epam.BookSpace.utils.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Menu {
    private static final Logger log = LogManager.getLogger();
    private final Scanner input = new Scanner(System.in);

    public void startMenu() {
        String str = "";
        Integer choice;
        while (true) {
            boolean flag = false;
            MenuTexts.printMain();
            System.out.print("Ваш выбор: ");
            str = input.nextLine();
            choice = Parser.parseInteger(str);
            System.out.println();
            UserView userView = new UserView();
            switch (choice) {
                case 0:
                    flag = true;
                    break;
                case 1:
                    userView.add();
                    break;
                case 2:
                    login();
                    break;
                default:
                    System.out.println("Некорректный ввод");
                    break;
            }
            System.out.println();
            if (flag) {
                break;
            }
        }
    }

    private void login() {
        String login = "", password = "";
        System.out.print("Введите логин: ");
        login = input.nextLine();
        System.out.print("Введите пароль: ");
        password = input.nextLine();
        System.out.println();
        AdminFileService adminFileService = new AdminFileService();
        Admin admin = adminFileService.getById(login);
        if (admin != null) {
            if (admin.getPassword().equals(password)) {
                adminMenu();
            } else {
                System.out.println("Неверный пароль");
            }
        } else {
            ReaderFileService readerFileService = new ReaderFileService();
            Reader user = readerFileService.getById(login);
            if (user != null) {
                if (user.getPassword().equals(password)) {
                    userMenu(login);
                } else {
                    System.out.println("Неверный пароль");
                }
            } else {
                System.out.println("Некорректные данные");
            }
        }
        System.out.println();
    }

    private void adminMenu() {
        String str = "";
        Integer choice;
        while (true) {
            boolean flag = false;
            MenuTexts.printAdmin();
            System.out.print("Ваш выбор: ");
            str = input.nextLine();
            choice = Parser.parseInteger(str);
            System.out.println();
            switch (choice) {
                case 0:
                    flag = true;
                    break;
                case 1:
                    adminMenuUsers();
                    break;
                case 2:
                    adminMenuAdmins();
                    break;
                case 3:
                    adminMenuBooks();
                    break;
                case 4:
                    adminMenuAuthors();
                    break;
                case 5:
                    adminMenuComments();
                    break;
                case 6:
                    adminMenuSeries();
                    break;
                case 7:
                    adminMenuStatistics();
                    break;
                default:
                    System.out.println("Некорректный ввод");
                    break;
            }
            System.out.println();
            if (flag) {
                break;
            }
        }
    }

    private void adminMenuUsers() {
        String str = "";
        Integer choice;
        while (true) {
            boolean flag = false;
            MenuTexts.printAdminUsers();
            System.out.print("Ваш выбор: ");
            str = input.nextLine();
            choice = Parser.parseInteger(str);
            System.out.println();
            UserView userView = new UserView();
            switch (choice) {
                case 0:
                    flag = true;
                    break;
                case 1:
                    userView.printAll();
                    break;
                case 2:
                    userView.add();
                    break;
                case 3:
                    userView.change();
                    break;
                case 4:
                    userView.delete();
                    break;
                case 5:
                    userView.print();
                    break;
                default:
                    System.out.println("Некорректный ввод");
                    break;
            }
            System.out.println();
            if (flag) {
                break;
            }
        }
    }

    private void adminMenuAdmins() {
        String str = "";
        Integer choice;
        while (true) {
            boolean flag = false;
            MenuTexts.printAdminAdmins();
            System.out.print("Ваш выбор: ");
            str = input.nextLine();
            choice = Parser.parseInteger(str);
            System.out.println();
            AdminView adminView = new AdminView();
            switch (choice) {
                case 0:
                    flag = true;
                    break;
                case 1:
                    adminView.printAll();
                    break;
                case 2:
                    adminView.add();
                    break;
                case 3:
                    adminView.change();
                    break;
                case 4:
                    adminView.delete();
                    break;
                case 5:
                    adminView.print();
                    break;
                default:
                    System.out.println("Некорректный ввод");
                    break;
            }
            System.out.println();
            if (flag) {
                break;
            }
        }
    }

    private void adminMenuBooks() {
        String str = "";
        Integer choice;
        while (true) {
            boolean flag = false;
            MenuTexts.printAdminBooks();
            System.out.print("Ваш выбор: ");
            str = input.nextLine();
            choice = Parser.parseInteger(str);
            System.out.println();
            BookView bookView = new BookView();
            switch (choice) {
                case 0:
                    flag = true;
                    break;
                case 1:
                    bookView.printAll();
                    break;
                case 2:
                    bookView.add();
                    break;
                case 3:
                    bookView.change();
                    break;
                case 4:
                    bookView.delete();
                    break;
                case 5:
                    bookView.print();
                    break;
                default:
                    System.out.println("Некорректный ввод");
                    break;
            }
            System.out.println();
            if (flag) {
                break;
            }
        }
    }

    private void adminMenuAuthors() {
        String str = "";
        Integer choice;
        while (true) {
            boolean flag = false;
            MenuTexts.printAdminAuthors();
            System.out.print("Ваш выбор: ");
            str = input.nextLine();
            choice = Parser.parseInteger(str);
            System.out.println();
            AuthorView authorView = new AuthorView();
            switch (choice) {
                case 0:
                    flag = true;
                    break;
                case 1:
                    authorView.printAll();
                    break;
                case 2:
                    authorView.add();
                    break;
                case 3:
                    authorView.change();
                    break;
                case 4:
                    authorView.delete();
                    break;
                case 5:
                    authorView.print();
                    break;
                default:
                    System.out.println("Некорректный ввод");
                    break;
            }
            System.out.println();
            if (flag) {
                break;
            }
        }
    }

    private void adminMenuComments() {
        String str = "";
        Integer choice;
        while (true) {
            boolean flag = false;
            MenuTexts.printAdminComments();
            System.out.print("Ваш выбор: ");
            str = input.nextLine();
            choice = Parser.parseInteger(str);
            System.out.println();
            CommentView commentView = new CommentView();
            switch (choice) {
                case 0:
                    flag = true;
                    break;
                case 1:
                    commentView.printAll();
                    break;
                case 2:
                    commentView.add();
                    break;
                case 3:
                    commentView.change();
                    break;
                case 4:
                    commentView.delete();
                    break;
                case 5:
                    commentView.print();
                    break;
                default:
                    System.out.println("Некорректный ввод");
                    break;
            }
            System.out.println();
            if (flag) {
                break;
            }
        }
    }

    private void adminMenuSeries() {
        String str = "";
        Integer choice;
        while (true) {
            boolean flag = false;
            MenuTexts.printAdminSeries();
            System.out.print("Ваш выбор: ");
            str = input.nextLine();
            choice = Parser.parseInteger(str);
            System.out.println();
            SeriesView seriesView = new SeriesView();
            switch (choice) {
                case 0:
                    flag = true;
                    break;
                case 1:
                    seriesView.printAll();
                    break;
                case 2:
                    seriesView.add();
                    break;
                case 3:
                    seriesView.change();
                    break;
                case 4:
                    seriesView.delete();
                    break;
                case 5:
                    seriesView.print();
                    break;
                default:
                    System.out.println("Некорректный ввод");
                    break;
            }
            System.out.println();
            if (flag) {
                break;
            }
        }
    }

    private void adminMenuStatistics() {
        String str = "";
        Integer choice;
        while (true) {
            boolean flag = false;
            MenuTexts.printAdminStatistics();
            System.out.print("Ваш выбор: ");
            str = input.nextLine();
            choice = Parser.parseInteger(str);
            System.out.println();
            StatisticsView statisticsView = new StatisticsView();
            switch (choice) {
                case 0:
                    flag = true;
                    break;
                case 1:
                    statisticsView.printAll();
                    break;
                case 2:
                    statisticsView.add();
                    break;
                case 3:
                    statisticsView.change();
                    break;
                case 4:
                    statisticsView.delete();
                    break;
                case 5:
                    statisticsView.print();
                    break;
                default:
                    System.out.println("Некорректный ввод");
                    break;
            }
            System.out.println();
            if (flag) {
                break;
            }
        }
    }

    private void userMenu(String login) {
        String str = "";
        Integer choice;
        while (true) {
            boolean flag = false;
            MenuTexts.printUser();
            System.out.print("Ваш выбор: ");
            str = input.nextLine();
            choice = Parser.parseInteger(str);
            System.out.println();
            switch (choice) {
                case 0:
                    flag = true;
                    break;
                case 1:
                    userMenuUser(login);
                    break;
                case 2:
                    userMenuBooks();
                    break;
                case 3:
                    userMenuAuthors();
                    break;
                case 4:
                    userMenuComments(login);
                    break;
                case 5:
                    userMenuSeries();
                    break;
                case 6:
                    userMenuStatistics();
                    break;
                default:
                    System.out.println("Некорректный ввод");
                    break;
            }
            System.out.println();
            if (flag) {
                break;
            }
        }
    }

    private void userMenuStatistics() {
        String str = "";
        Integer choice;
        while (true) {
            boolean flag = false;
            MenuTexts.printUserSeries();
            System.out.print("Ваш выбор: ");
            str = input.nextLine();
            choice = Parser.parseInteger(str);
            System.out.println();
            StatisticsView statisticsView = new StatisticsView();
            switch (choice) {
                case 0:
                    flag = true;
                    break;
                case 1:
                    statisticsView.printAll();
                    break;
                case 2:
                    statisticsView.print();
                    break;
                default:
                    System.out.println("Некорректный ввод");
                    break;
            }
            System.out.println();
            if (flag) {
                break;
            }
        }
    }

    private void userMenuSeries() {
        String str = "";
        Integer choice;
        while (true) {
            boolean flag = false;
            MenuTexts.printUserSeries();
            System.out.print("Ваш выбор: ");
            str = input.nextLine();
            choice = Parser.parseInteger(str);
            System.out.println();
            SeriesView seriesView = new SeriesView();
            switch (choice) {
                case 0:
                    flag = true;
                    break;
                case 1:
                    seriesView.printAll();
                    break;
                case 2:
                    seriesView.print();
                    break;
                default:
                    System.out.println("Некорректный ввод");
                    break;
            }
            System.out.println();
            if (flag) {
                break;
            }
        }
    }

    private void userMenuComments(String login) {
        String str = "";
        Integer choice;
        while (true) {
            boolean flag = false;
            MenuTexts.printUserComments();
            System.out.print("Ваш выбор: ");
            str = input.nextLine();
            choice = Parser.parseInteger(str);
            System.out.println();
            CommentView commentView = new CommentView();
            switch (choice) {
                case 0:
                    flag = true;
                    break;
                case 1:
                    commentView.printAll();
                    break;
                case 2:
                    commentView.printAllBookComments();
                    break;
                case 3:
                    commentView.addCommentUser(login);
                    break;
                case 4:
                    commentView.changeCommentUser(login);
                    break;
                case 5:
                    commentView.deleteCommentUser(login);
                    break;
                case 6:
                    commentView.print();
                    break;
                default:
                    System.out.println("Некорректный ввод");
                    break;
            }
            System.out.println();
            if (flag) {
                break;
            }
        }
    }

    private void userMenuAuthors() {
        String str = "";
        Integer choice;
        while (true) {
            boolean flag = false;
            MenuTexts.printUserAuthors();
            System.out.print("Ваш выбор: ");
            str = input.nextLine();
            choice = Parser.parseInteger(str);
            System.out.println();
            AuthorView authorView = new AuthorView();
            switch (choice) {
                case 0:
                    flag = true;
                    break;
                case 1:
                    authorView.printAll();
                    break;
                case 2:
                    authorView.print();
                    break;
                default:
                    System.out.println("Некорректный ввод");
                    break;
            }
            System.out.println();
            if (flag) {
                break;
            }
        }
    }

    private void userMenuBooks() {
        String str = "";
        Integer choice;
        while (true) {
            boolean flag = false;
            MenuTexts.printUserBooks();
            System.out.print("Ваш выбор: ");
            str = input.nextLine();
            choice = Parser.parseInteger(str);
            System.out.println();
            BookView bookView = new BookView();
            switch (choice) {
                case 0:
                    flag = true;
                    break;
                case 1:
                    bookView.printAll();
                    break;
                case 2:
                    bookView.printAllBooksAuthor();
                    break;
                case 3:
                    bookView.printAllBooksGenre();
                    break;
                case 4:
                    bookView.printAllBooksSeries();
                    break;
                case 5:
                    bookView.print();
                    break;
                default:
                    System.out.println("Некорректный ввод");
                    break;
            }
            System.out.println();
            if (flag) {
                break;
            }
        }
    }

    private void userMenuUser(String login) {
        String str = "";
        Integer choice;
        while (true) {
            boolean flag = false;
            MenuTexts.printUserUser();
            System.out.print("Ваш выбор: ");
            str = input.nextLine();
            choice = Parser.parseInteger(str);
            System.out.println();
            UserView userView = new UserView();
            switch (choice) {
                case 0:
                    flag = true;
                    break;
                case 1:
                    userView.changeNickname(login);
                    break;
                case 2:
                    userView.changeEmail(login);
                    break;
                case 3:
                    userView.changePassword(login);
                    break;
                default:
                    System.out.println("Некорректный ввод");
                    break;
            }
            System.out.println();
            if (flag) {
                break;
            }
        }
    }
}