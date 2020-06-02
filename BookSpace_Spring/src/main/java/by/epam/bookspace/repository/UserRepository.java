package by.epam.bookspace.repository;

import by.epam.bookspace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserRepository extends JpaRepository<User, Integer> {
    Set<User> findByLoginOrNicknameOrEmail(String login, String nickname, String email);
    User findByLogin(String login);
}