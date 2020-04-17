package by.epam.BookSpace.runner.views;

import by.epam.BookSpace.model.Comment;
import by.epam.BookSpace.model.Reader;
import by.epam.BookSpace.runner.View;
import by.epam.BookSpace.services.file.AdminFileService;
import by.epam.BookSpace.services.file.CommentFileService;
import by.epam.BookSpace.services.file.ReaderFileService;
import by.epam.BookSpace.utils.inputs.ReaderInput;

import java.util.ArrayList;

public class UserView extends View<Reader, String> {
    public UserView() {
        this.service = new ReaderFileService();
        this.inputData = new ReaderInput();
    }

    @Override
    public void add() {
        AdminFileService adminFileService = new AdminFileService();
        Reader reader = this.inputData.inputItem();
        if (reader != null) {
            System.out.println(reader.getLogin());
            if ((this.service.getById(reader.getLogin()) != null) || (adminFileService.getById(reader.getLogin()) != null)) {
                System.out.println("Пользователь с таким логином уже существует");
            } else {
                service.insert(reader);
            }
        } else {
            System.out.println("Некорректные данные");
        }
        System.out.println();
    }

    @Override
    public void delete() {
        System.out.print("Введите id: ");
        String id = inputData.inputId();
        Reader item = service.getById(id);
        if (item != null) {
            if (service.delete(id)) {
                CommentFileService commentFileService = new CommentFileService();
                ArrayList<Comment> comments = commentFileService.getAll();
                for (Comment comment : comments) {
                    if (comment.getUserLogin().equals(id)) {
                        commentFileService.delete(comment.getId());
                    }
                }
            }
        } else {
            System.out.println("Некорректные данные");
        }
        System.out.println();
    }

    public void changeNickname(String login) {
        String newNickname = ((ReaderInput) this.inputData).inputNickname();
        if (newNickname != null) {
            Reader user = this.service.getById(login);
            user.setNickname(newNickname);
            this.service.update(login, user);
        } else {
            System.out.println("Некорректные данные");
        }
        System.out.println();
    }

    public void changeEmail(String login) {
        String newEmail = ((ReaderInput) this.inputData).inputEmail();
        if (newEmail != null) {
            Reader user = this.service.getById(login);
            user.setEmail(newEmail);
            this.service.update(login, user);
        } else {
            System.out.println("Некорректные данные");
        }
        System.out.println();
    }

    public void changePassword(String login) {
        String newPassword = ((ReaderInput) this.inputData).inputPassword();
        if (newPassword != null) {
            Reader user = this.service.getById(login);
            user.setPassword(newPassword);
            this.service.update(login, user);
        } else {
            System.out.println("Некорректные данные");
        }
        System.out.println();
    }
}