package by.epam.BookSpace.services;

import by.epam.BookSpace.model.Comment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.UUID;

public class CommentFilterService {
    protected static final Logger log = LogManager.getLogger();

    public ArrayList<Comment> getAllBookComments(ArrayList<Comment> allComments, UUID bookId) {
        ArrayList<Comment> comments = new ArrayList<>();
        if (bookId != null) {
            for (Comment comment : allComments) {
                if (comment.getBookId() == bookId) {
                    comments.add(comment);
                }
            }
            log.info("Возвращен список комментариев книги с id=" + bookId.toString());
        } else {
            log.info("Ошибка! В функцию передано значение null");
        }
        return comments;
    }
}
