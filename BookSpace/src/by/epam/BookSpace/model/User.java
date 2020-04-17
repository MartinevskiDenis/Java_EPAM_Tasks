package by.epam.BookSpace.model;

import java.io.Serializable;
import java.util.Objects;

public abstract class User implements Serializable, Cloneable {
    private static final long serialVersionUID = -7347079179565262603L;
    private String login;
    private String email;
    private String nickname;
    private String password;

    public User() {
        this.login = "";
        this.email = "";
        this.nickname = "";
        this.password = "";
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("login=").append(login);
        sb.append(", email=").append(email);
        sb.append(", nickname=").append(nickname);
        sb.append(", password=").append(password);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return login.equals(user.login) &&
                email.equals(user.email) &&
                nickname.equals(user.nickname) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, email, nickname, password);
    }
}