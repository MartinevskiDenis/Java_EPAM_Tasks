package by.epam.BookSpace.services.file;

import by.epam.BookSpace.dao.DAO;
import by.epam.BookSpace.dao.file.FileBookDAO;
import by.epam.BookSpace.model.Book;
import by.epam.BookSpace.services.Service;

import java.io.File;

public class BookFileService extends Service<Book, Integer, DAO<Book, Integer>> {

    public BookFileService()
    {
        this.dao = new FileBookDAO("data" + File.separator + "book.txt");
    }
}
