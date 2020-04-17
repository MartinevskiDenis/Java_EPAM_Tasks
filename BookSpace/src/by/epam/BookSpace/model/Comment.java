package by.epam.BookSpace.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Comment implements Serializable {
    private static final long serialVersionUID = 9005210832136607497L;
    private String userLogin;
    private String text;
    private UUID bookId;
    private UUID id;

    public Comment() {
        this.userLogin = "";
        this.text = "";
        this.bookId = null;
        this.id = UUID.randomUUID();
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UUID getBookId() {
        return bookId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Comment{ ");
        sb.append("userLogin=").append(userLogin);
        sb.append(", text=").append(text);
        sb.append(", bookID=").append(bookId);
        sb.append(", id=").append(id);
        sb.append(" }");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return bookId == comment.bookId &&
                id == comment.id &&
                userLogin.equals(comment.userLogin) &&
                text.equals(comment.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userLogin, text, bookId, id);
    }
}
