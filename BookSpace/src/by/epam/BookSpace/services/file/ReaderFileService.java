package by.epam.BookSpace.services.file;

import by.epam.BookSpace.dao.file.ReaderFileDAO;
import by.epam.BookSpace.model.Reader;
import by.epam.BookSpace.services.Service;

import java.io.File;

public class ReaderFileService extends Service<Reader, String> {
    public ReaderFileService() {
        this.dao = new ReaderFileDAO("data" + File.separator + "users.txt");
    }
}