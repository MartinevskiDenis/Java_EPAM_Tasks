package by.epam.BookSpace.services.file;

import by.epam.BookSpace.dao.file.BookFileDAO;
import by.epam.BookSpace.model.Book;
import by.epam.BookSpace.services.Service;
import by.epam.BookSpace.utils.Constants;

import java.util.UUID;

public class BookFileService extends Service<Book, UUID> {

    public BookFileService() {
        this.dao = new BookFileDAO(Constants.PATH_BOOKS);
    }
}