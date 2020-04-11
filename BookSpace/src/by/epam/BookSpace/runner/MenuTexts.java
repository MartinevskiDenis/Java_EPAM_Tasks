package by.epam.BookSpace.runner;

public class MenuTexts {
    public static void printMain(){
        System.out.println("1 - Регистрация");
        System.out.println("2 - Вход");
        System.out.println("0 - Выход");
    }

    public static void printAdmin() {
        System.out.println("1 - Пользователи");
        System.out.println("2 - Администраторы");
        System.out.println("3 - Книги");
        System.out.println("4 - Авторы");
        System.out.println("5 - Комментарии");
        System.out.println("6 - Серии книг");
        System.out.println("7 - Статистика книг");
        System.out.println("0 - Назад");
    }

    public static void printAdminUsers() {
        System.out.println("1 - Вывести всех пользователей");
        System.out.println("2 - Добавить пользователя");
        System.out.println("3 - Изменить пользователя");
        System.out.println("4 - Удалить пользователя");
        System.out.println("0 - Назад");
    }

    public static void printUser() {
        System.out.println("1 - Редактировать профиль");
        System.out.println("2 - Книги");
        System.out.println("3 - Авторы");
        System.out.println("4 - Комментарии");
        System.out.println("5 - Серии книг");
        System.out.println("0 - Назад");
    }
}
