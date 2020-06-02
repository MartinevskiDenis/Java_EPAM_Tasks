package by.epam.bookspace.repository;

import by.epam.bookspace.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
