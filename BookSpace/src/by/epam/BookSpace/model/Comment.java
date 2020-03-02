package by.epam.BookSpace.model;

import java.util.Objects;

public class Comment {
    private String userLogin;
    private String text;
    private int bookID;

    public Comment() {
        this.userLogin = "";
        this.text = "";
        this.bookID = 0;
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

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Comment{ ");
        sb.append("userLogin=").append(userLogin);
        sb.append(", text=").append(text);
        sb.append(", bookID=").append(bookID);
        sb.append(" }");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return bookID == comment.bookID &&
                userLogin.equals(comment.userLogin) &&
                text.equals(comment.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userLogin, text, bookID);
    }
}
