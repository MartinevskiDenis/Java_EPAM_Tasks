package by.epam.BookSpace.utils.inputs;

import by.epam.BookSpace.model.Comment;
import by.epam.BookSpace.utils.InputData;
import by.epam.BookSpace.utils.Parser;

import java.util.UUID;
import java.util.concurrent.CompletionException;

public class CommentInput extends InputData<Comment, UUID> {
    @Override
    public Comment inputItem() {
        Comment comment = new Comment();
        System.out.print("Введите логин пользователя: ");
        String str = input.nextLine();
        if (str.equals("")) {
            return null;
        }
        comment.setUserLogin(str);
        System.out.print("Введите id книги: ");
        UUID id = inputId();
        if (id == null) {
            return null;
        }
        comment.setBookId(id);
        str = inputText();
        if (str == null) {
            return null;
        }
        comment.setText(str);
        return comment;
    }

    @Override
    public UUID inputId() {
        String str = input.nextLine();
        UUID id = Parser.parseUUID(str);
        return id;
    }

    public Comment inputItemUser() {
        Comment comment = new Comment();
        System.out.print("Введите id книги: ");
        UUID id = inputId();
        if (id == null) {
            return null;
        }
        comment.setBookId(id);
        String str = inputText();
        if (str == null) {
            return null;
        }
        comment.setText(str);
        return comment;
    }

    public String inputText() {
        System.out.print("Введите текст комментария: ");
        String str = input.nextLine();
        if (str.equals("")) {
            return null;
        }
        return str;
    }
}
