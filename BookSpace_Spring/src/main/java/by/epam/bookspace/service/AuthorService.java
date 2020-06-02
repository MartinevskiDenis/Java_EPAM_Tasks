package by.epam.bookspace.service;

import by.epam.bookspace.model.Author;
import by.epam.bookspace.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public void add(Author author) {
        authorRepository.save(author);
    }

    public ArrayList<Author> getAll() {
        return authorRepository.findAll();
    }
}
