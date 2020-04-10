package by.epam.BookSpace.services.file;

import by.epam.BookSpace.dao.file.CommentFileDAO;
import by.epam.BookSpace.model.Comment;
import by.epam.BookSpace.services.Service;

import java.io.File;
import java.util.UUID;

public class CommentFileService extends Service<Comment, UUID> {
    public CommentFileService() {
        this.dao = new CommentFileDAO("data" + File.separator + "comments.txt");
    }
}
