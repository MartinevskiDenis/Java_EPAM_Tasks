package by.epam.bookspace.controller;

import by.epam.bookspace.model.Author;
import by.epam.bookspace.repository.AuthorRepository;
import by.epam.bookspace.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping
    public String main() {
        return "authors";
    }

    @GetMapping("/add")
    public String add() {
        return "add_author";
    }

    @PostMapping("/add")
    public String addAuthor(@RequestParam String name, @RequestParam String surname, Model model) {
        Author author = new Author();
        author.setName(name);
        author.setSurname(surname);
        authorService.add(author);
        return "add_author";
    }

    @GetMapping("/all")
    public String all(Model model) {
        Iterable<Author> authors = authorService.getAll();
        model.addAttribute("authors", authors);
        return "all_authors";
    }
}
