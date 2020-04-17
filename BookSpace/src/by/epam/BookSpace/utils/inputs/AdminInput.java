package by.epam.BookSpace.utils.inputs;

import by.epam.BookSpace.model.Admin;
import by.epam.BookSpace.utils.InputData;

public class AdminInput extends InputData<Admin, String> {
    @Override
    public Admin inputItem() {
        Admin admin = new Admin();
        System.out.print("Введите e-mail: ");
        String str = input.nextLine();
        if (str.equals("")) {
            return null;
        }
        admin.setEmail(str);
        System.out.print("Введите логин: ");
        str = input.nextLine();
        if (str.equals("")) {
            return null;
        }
        admin.setEmail(str);
        System.out.print("Введите пароль: ");
        str = input.nextLine();
        admin.setPassword(str);
        if (str.equals("")) {
            return null;
        }
        System.out.print("Введите никнейм: ");
        str = input.nextLine();
        if (str.equals("")) {
            return null;
        }
        admin.setNickname(str);
        return admin;
    }

    @Override
    public String inputId() {
        String id = input.nextLine();
        if (id.equals("")) {
            return null;
        }
        return id;
    }
}
