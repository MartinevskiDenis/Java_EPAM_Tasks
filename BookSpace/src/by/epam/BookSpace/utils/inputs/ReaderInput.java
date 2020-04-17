package by.epam.BookSpace.utils.inputs;

import by.epam.BookSpace.model.Reader;
import by.epam.BookSpace.utils.InputData;

public class ReaderInput extends InputData<Reader, String> {

    @Override
    public Reader inputItem() {
        Reader reader = new Reader();
        System.out.print("Введите e-mail: ");
        String str = input.nextLine();
        if (str.equals("")) {
            return null;
        }
        reader.setEmail(str);
        System.out.print("Введите логин: ");
        str = input.nextLine();
        if (str.equals("")) {
            return null;
        }
        reader.setLogin(str);
        System.out.print("Введите пароль: ");
        str = input.nextLine();
        reader.setPassword(str);
        if (str.equals("")) {
            return null;
        }
        System.out.print("Введите никнейм: ");
        str = input.nextLine();
        if (str.equals("")) {
            return null;
        }
        reader.setNickname(str);
        return reader;
    }

    @Override
    public String inputId() {
        String id = input.nextLine();
        if (id.equals("")) {
            return null;
        }
        return id;
    }

    public String inputNickname() {
        System.out.print("Введите новый nickname: ");
        String str = input.nextLine();
        if (str.equals("")) {
            return null;
        }
        return str;
    }

    public String inputEmail() {
        System.out.print("Введите новый email: ");
        String str = input.nextLine();
        if (str.equals("")) {
            return null;
        }
        return str;
    }

    public String inputPassword() {
        System.out.print("Введите новый password: ");
        String str = input.nextLine();
        if (str.equals("")) {
            return null;
        }
        return str;
    }
}