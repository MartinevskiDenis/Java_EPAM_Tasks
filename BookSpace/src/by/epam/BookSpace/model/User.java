package by.epam.BookSpace.model;

public class User {
    protected String login;
    protected String email;
    protected String nickname;

    public User() {
        this.login = "";
        this.email = "";
        this.nickname = "";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{ ");
        sb.append("login=").append(login);
        sb.append(", email=").append(email);
        sb.append(", nickname=").append(nickname);
        sb.append(" }");
        return sb.toString();
    }
}