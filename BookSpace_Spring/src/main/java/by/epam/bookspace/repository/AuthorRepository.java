package by.epam.bookspace.repository;

import by.epam.bookspace.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    ArrayList<Author> findAll();
}
