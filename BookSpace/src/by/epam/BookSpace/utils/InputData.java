package by.epam.BookSpace.utils;

import by.epam.BookSpace.model.Reader;

import java.util.Scanner;

public class InputData {
    public static boolean inputReader(Scanner scanner, Reader reader){
        String str;
        System.out.print("Введите e-mail: ");
        str=scanner.nextLine();
        reader.setEmail(str);
        System.out.print("Введите логин: ");
        str=scanner.nextLine();
        reader.setEmail(str);
        System.out.print("Введите пароль: ");
        str=scanner.nextLine();
        reader.setPassword(str);
        System.out.print("Введите никнейм: ");
        str=scanner.nextLine();
        reader.setNickname(str);
        return true;
    }
}