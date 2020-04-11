package by.epam.BookSpace.runner;

import by.epam.BookSpace.model.Admin;
import by.epam.BookSpace.model.Reader;
import by.epam.BookSpace.services.file.AdminFileService;
import by.epam.BookSpace.services.file.ReaderFileService;
import by.epam.BookSpace.utils.InputData;
import by.epam.BookSpace.utils.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static final Logger log = LogManager.getLogger();
    private final Scanner input = new Scanner(System.in);

    public void startMenu() {
        String str;
        Integer choice;
        while (true) {
            boolean flag = false;
            MenuTexts.printMain();
            System.out.print("Ваш выбор: ");
            str = input.nextLine();
            choice = Parser.parseInteger(str);
            System.out.println();
            switch (choice) {
                case 0:
                    flag = true;
                    break;
                case 1:
                    addUser();
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

    private void addUser() {
        ReaderFileService readerFileService = new ReaderFileService();
        AdminFileService adminFileService = new AdminFileService();
        Reader reader = new Reader();
        if (InputData.inputReader(input, reader)) {
            if ((readerFileService.getById(reader.getLogin()) != null) || (adminFileService.getById(reader.getLogin()) != null)) {
                System.out.println("Пользователь с таким логином уже существует");
            } else {
                readerFileService.insert(reader);
            }
        } else {
            System.out.println("Некорректный данные");
        }
        System.out.println();
    }

    private void login() {
        String login, password;
        System.out.print("Введите логин: ");
        login = input.nextLine();
        System.out.print("Введите пароль: ");
        password = input.nextLine();
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
                System.out.println("Некорректный данные");
            }
        }
        System.out.println();
    }

    private void adminMenu() {
        String str;
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
        String str;
        Integer choice;
        while (true) {
            boolean flag = false;
            MenuTexts.printAdminUsers();
            System.out.print("Ваш выбор: ");
            str = input.nextLine();
            choice = Parser.parseInteger(str);
            System.out.println();
            switch (choice) {
                case 0:
                    flag = true;
                    break;
                case 1:
                    printAllUsers();
                    break;
                case 2:
                    addUser();
                    break;
                case 3:
                    changeUser();
                    break;
                case 4:
                    deleteUser();
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

    private void changeUser() {
        String login;
        System.out.print("Введите логин: ");
        login = input.nextLine();
        Reader newReader = new Reader();
        System.out.println("Введите новые значения пользователя");
        InputData.inputReader(input, newReader);
        newReader.setLogin(login);
        ReaderFileService readerFileService = new ReaderFileService();
        if(readerFileService.update(login, newReader)
        System.out.println();
    }



    private void printAllUsers() {
        ReaderFileService readerFileService = new ReaderFileService();
        ArrayList<Reader> items = readerFileService.getAll();
        for(Reader reader : items){
            System.out.println(reader);
            System.out.println();
        }
        System.out.println();
    }

    private void adminMenuAdmins() {
    }

    private void adminMenuBooks() {
    }

    private void adminMenuAuthors() {
    }

    private void adminMenuComments() {
    }

    private void adminMenuSeries() {
    }

    private void adminMenuStatistics() {
    }

    private void userMenu(String login) {
        String str;
        Integer choice;
        while (true) {
            boolean flag = false;
            printMenuUser();
            System.out.print("Ваш выбор: ");
            str = input.nextLine();
            choice = Parser.parseInteger(str);
            System.out.println();
            switch (choice) {
                case 0:
                    flag = true;
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