package by.epam.BookSpace.runner.views;

import by.epam.BookSpace.model.Admin;
import by.epam.BookSpace.model.Comment;
import by.epam.BookSpace.runner.View;
import by.epam.BookSpace.services.file.AdminFileService;
import by.epam.BookSpace.services.file.CommentFileService;
import by.epam.BookSpace.services.file.ReaderFileService;
import by.epam.BookSpace.utils.inputs.AdminInput;

import java.util.ArrayList;


public class AdminView extends View<Admin, String> {
    public AdminView() {
        this.service = new AdminFileService();
        this.inputData = new AdminInput();
    }

    @Override
    public void add() {
        ReaderFileService readerFileService = new ReaderFileService();
        Admin admin = this.inputData.inputItem();
        if (admin != null) {
            if ((this.service.getById(admin.getLogin()) != null) || (readerFileService.getById(admin.getLogin()) != null)) {
                System.out.println("Пользователь с таким логином уже существует");
            } else {
                service.insert(admin);
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
        Admin item = service.getById(id);
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
}