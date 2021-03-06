package by.epam.BookSpace.services.file;

import by.epam.BookSpace.dao.file.AuthorFileDAO;
import by.epam.BookSpace.model.Author;
import by.epam.BookSpace.services.Service;
import by.epam.BookSpace.utils.Constants;

import java.util.UUID;

public class AuthorFileService extends Service<Author, UUID> {

    public AuthorFileService() {
        this.dao = new AuthorFileDAO(Constants.PATH_AUTHORS);
    }
}