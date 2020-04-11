package by.epam.BookSpace.services.file;

import by.epam.BookSpace.dao.file.CommentFileDAO;
import by.epam.BookSpace.model.Comment;
import by.epam.BookSpace.services.Service;
import by.epam.BookSpace.utils.Constants;

import java.util.UUID;

public class CommentFileService extends Service<Comment, UUID> {
    public CommentFileService() {
        this.dao = new CommentFileDAO(Constants.PATH_COMMENTS);
    }
}
