package by.epam.BookSpace.runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Menu {
    private static final Logger log = LogManager.getLogger();

    public void start() {

    }

    private void printMenuMain(){
        System.out.println("1 - Регистрация");
        System.out.println("2 - Вход");
        System.out.println("0 - Выход");
    }
}
