package by.epam.BookSpace.services.file;

import by.epam.BookSpace.dao.file.ReaderFileDAO;
import by.epam.BookSpace.model.Reader;
import by.epam.BookSpace.services.Service;
import by.epam.BookSpace.utils.Constants;

public class ReaderFileService extends Service<Reader, String> {
    public ReaderFileService() {
        this.dao = new ReaderFileDAO(Constants.PATH_READERS);
    }
}