package by.epam.BookSpace.model;

import java.util.Objects;

public abstract class User {
    protected String login;
    protected String email;
    protected String nickname;
    protected String password;
    protected boolean isSubscriber;

    public User() {
        this.login = "";
        this.email = "";
        this.nickname = "";
        this.isSubscriber = false;
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

    public boolean isSubscriber() {
        return isSubscriber;
    }

    public void setSubscriber(boolean subscriber) {
        isSubscriber = subscriber;
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
        sb.append(", isSubscriber=").append(isSubscriber);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isSubscriber == user.isSubscriber &&
                login.equals(user.login) &&
                email.equals(user.email) &&
                nickname.equals(user.nickname) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, email, nickname, password, isSubscriber);
    }
}